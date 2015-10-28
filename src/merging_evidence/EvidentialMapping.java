package merging_evidence;

import java.util.HashMap;
import java.util.Map;

public class EvidentialMapping<T, U> {
	
	private AdvancedSet<T> evidenceFrame;
	private AdvancedSet<U> hypothesesFrame;
	
	private Map<T, BBA<U>> masses;
	
	public EvidentialMapping(AdvancedSet<T> eSet, AdvancedSet<U> hSet) {
		evidenceFrame = eSet;
		hypothesesFrame = hSet;
		masses = new HashMap<T, BBA<U>>();
	}
	
	public AdvancedSet<T> getEvidenceFrame() {
		return evidenceFrame;
	}
	
	public AdvancedSet<U> getHypothesesFrame() {
		return hypothesesFrame;
	}
	
	public Map<T, BBA<U>> getMasses() {
		return masses;
	}
	
	public void addMass(T e, AdvancedSet<U> hSet, double value) {
		if(value < 0 || value > 1) {
			if(value < 0 && value > 0 - Utilities.DEVIATION) {
				value = (double)0;
			} else if(value > 1 && value < 1 + Utilities.DEVIATION) {
				value = (double)1;
			} else {
				throw new IllegalArgumentException("The mass value must be in the range [0, 1].");
			}
		}
		if(!evidenceFrame.contains(e)) {
			throw new IllegalArgumentException("The evidence input must be an element of the evidence frame.");
		}
		if(!hSet.subsetOf(hypothesesFrame)) {
			throw new IllegalArgumentException("The hypotheses input must be a subset of the hypotheses frame.");
		}
		
		BBA<U> bba;
		if(!masses.containsKey(e)) {
			bba = new BBA<U>(e.toString(), hypothesesFrame);
		} else {
			bba = masses.get(e);
		}
		bba.setMass(hSet, value);
		masses.put(e, bba);
	}

	public double getMass(T e, AdvancedSet<U> hSet) {
		double result = 0;
		if(masses.containsKey(e)) {
			result = masses.get(e).getMass(hSet);
		}
		return result;
	}
	
	public BBA<U> getBayesianEvidencePropagation(BBA<T> evidence) {
		ProbabilityDistribution<T> p = evidence.getPignisticTransformation();
		
		Map<AdvancedSet<U>, Double> sums = new HashMap<AdvancedSet<U>, Double>();
		for(Map.Entry<T, BBA<U>> entry : masses.entrySet()) {
			T e = entry.getKey();
			BBA<U> bba = entry.getValue();
			for(Map.Entry<AdvancedSet<U>, Double> innerEntry : bba.getMasses().entrySet()) {
				AdvancedSet<U> hSet = innerEntry.getKey();
				double mass = innerEntry.getValue();
				double previous = 0;
				if(sums.containsKey(hSet)) {
					previous = sums.get(hSet);
				}
				sums.put(hSet, previous + (p.get(e) * mass));
			}
		}
		
		BBA<U> evidencePropagation = new BBA<U>(evidence.getLabel() + "^h", hypothesesFrame);
		for(Map.Entry<AdvancedSet<U>, Double> entry : sums.entrySet()) {
			evidencePropagation.setMass(entry.getKey(), entry.getValue());
		}
		
		return evidencePropagation;
	}
	
	public double getCompleteMass(AdvancedSet<T> eSet, AdvancedSet<U> hSet) {
		double result = 0;
		
		double sum = 0;
		boolean first = true;
		for(T e : eSet) {
			BBA<U> bba = masses.get(e);
			double mass = bba.getMass(hSet);
			if(mass > 0 + Utilities.DEVIATION) {
				sum += mass;
			} else {
				first = false;
				break;
			}
		}
		if(first) {
			result += sum / (double)eSet.size();
		}
		
		AdvancedSet<AdvancedSet<U>> focalElements = new AdvancedSet<AdvancedSet<U>>();
		for(T e : eSet) {
			focalElements.addAll(masses.get(e).getFocalElements());
		}
		
		AdvancedSet<U> union = new AdvancedSet<U>();
		for(AdvancedSet<U> focalElement : focalElements) {
			union.addAll(focalElement);
		}
		
		if(hSet.equals(union)) {
			sum = 0;
			for(AdvancedSet<U> focalElement : focalElements) {
				double innerSum = 0;
				first = true;
				for(T e : eSet) {
					BBA<U> bba = masses.get(e);
					double mass = bba.getMass(focalElement);
					if(mass > 0 + Utilities.DEVIATION) {
						innerSum += mass;
					} else {
						first = false;
						break;
					}
				}
				if(first) {
					sum += innerSum / (double)eSet.size();
				}
			}
			
			result += 1 - sum;
		}
		
		return result;
	}
	
	public BBA<U> getEvidencePropagation(BBA<T> evidence) {
		Map<AdvancedSet<U>, Double> sums = new HashMap<AdvancedSet<U>, Double>();
		for(Map.Entry<AdvancedSet<T>, Double> entry : evidence.getMasses().entrySet()) {
			AdvancedSet<T> eSet = entry.getKey();
			double mass = entry.getValue();
			
			AdvancedSet<AdvancedSet<U>> focalElements = new AdvancedSet<AdvancedSet<U>>();
			for(T e : eSet) {
				focalElements.addAll(masses.get(e).getFocalElements());
			}
			AdvancedSet<U> union = new AdvancedSet<U>();
			for(AdvancedSet<U> focalElement : focalElements) {
				double previous = 0;
				if(sums.containsKey(focalElement)) {
					previous = sums.get(focalElement);
				}
				double gamma = this.getCompleteMass(eSet, focalElement);
				sums.put(focalElement, previous + (mass * gamma));
				union.addAll(focalElement);
			}
			if(!focalElements.contains(union)) {
				double previous = 0;
				if(sums.containsKey(union)) {
					previous = sums.get(union);
				}
				double gamma = this.getCompleteMass(eSet, union);
				sums.put(union, previous + (mass * gamma));
			}
		}
		BBA<U> evidencePropagation = new BBA<U>(evidence.getLabel() + "^h", hypothesesFrame);
		for(Map.Entry<AdvancedSet<U>, Double> entry : sums.entrySet()) {
			evidencePropagation.setMass(entry.getKey(), entry.getValue());
		}
		return evidencePropagation;
	}
	
	@Override
	public String toString() {
		String output = "{";
		String delim = "";
		for(Map.Entry<T, BBA<U>> entry : masses.entrySet()) {
			output += delim + "\\Gamma(" + entry.getKey().toString() + ")=" + entry.getValue().toString();
			delim = ", ";
		}
		output += "}";
		return output;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((evidenceFrame == null) ? 0 : evidenceFrame.hashCode());
		result = prime * result
				+ ((hypothesesFrame == null) ? 0 : hypothesesFrame.hashCode());
		result = prime * result + ((masses == null) ? 0 : masses.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		EvidentialMapping<T, U> other = (EvidentialMapping<T, U>) obj;
		if (evidenceFrame == null) {
			if (other.evidenceFrame != null)
				return false;
		} else if (!evidenceFrame.equals(other.evidenceFrame))
			return false;
		if (hypothesesFrame == null) {
			if (other.hypothesesFrame != null)
				return false;
		} else if (!hypothesesFrame.equals(other.hypothesesFrame))
			return false;
		if (masses == null) {
			if (other.masses != null)
				return false;
		} else if (!masses.equals(other.masses))
			return false;
		return true;
	}
	
}
