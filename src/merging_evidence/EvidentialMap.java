package merging_evidence;

import java.util.HashMap;
import java.util.Map;

public class EvidentialMap<T, U> {
	
	private AdvancedSet<T> evidenceFrame;
	private AdvancedSet<U> hypothesesFrame;
	private Map<Pair<T, AdvancedSet<U>>, Double> masses;
	
	public EvidentialMap(AdvancedSet<T> e, AdvancedSet<U> h) {
		evidenceFrame = e;
		hypothesesFrame = h;
		masses = new HashMap<Pair<T, AdvancedSet<U>>, Double>();
	}
	
	public AdvancedSet<T> getEvidenceFrame() {
		return evidenceFrame;
	}
	
	public AdvancedSet<U> getHypothesesFrame() {
		return hypothesesFrame;
	}
	
	public Map<Pair<T, AdvancedSet<U>>, Double> getMasses() {
		return masses;
	}
	
	public void addMass(T e, AdvancedSet<U> h, double value) {
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
		if(!h.subsetOf(hypothesesFrame)) {
			throw new IllegalArgumentException("The hypotheses input must be a subset of the hypotheses frame.");
		}
		Pair<T, AdvancedSet<U>> pair = new Pair<T, AdvancedSet<U>>(e, h);
		if(value < 0 + Utilities.DEVIATION) {
			masses.remove(pair);
		} else {
			masses.put(pair, value);
		}
	}

	public double getMass(T e, AdvancedSet<U> h) {
		double result = 0;
		Pair<T, AdvancedSet<U>> pair = new Pair<T, AdvancedSet<U>>(e, h);
		if(masses.containsKey(pair)) {
			result = masses.get(pair);
		}
		return result;
	}
	
	public BBA<U> getEvidencePropagation(BBA<T> evidence) {
		ProbabilityDistribution<T> p = evidence.getPignisticTransformation();
		
		Map<AdvancedSet<U>, Double> sums = new HashMap<AdvancedSet<U>, Double>();
		for(Map.Entry<Pair<T, AdvancedSet<U>>, Double> entry : masses.entrySet()) {
			Pair<T, AdvancedSet<U>> pair = entry.getKey();
			T e = pair.getLeft();
			AdvancedSet<U> h = pair.getRight();
			double mass = entry.getValue();
			double previous = 0;
			if(sums.containsKey(h)) {
				previous = sums.get(h);
			}
			sums.put(h, previous + (p.get(e) * mass));
		}
		
		BBA<U> evidencePropagation = new BBA<U>("\\Gamma*", hypothesesFrame);
		for(Map.Entry<AdvancedSet<U>, Double> entry : sums.entrySet()) {
			evidencePropagation.addMass(entry.getKey(), entry.getValue());
		}
		
		return evidencePropagation;
	}
	
}
