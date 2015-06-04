package merging_evidence;

import java.util.HashMap;
import java.util.Map;

public class BBA<T> {
	
	private String label;
	private AdvancedSet<T> frame;
	private Map<AdvancedSet<T>, Double> masses;
	
	public BBA(String l, AdvancedSet<T> f) {
		label = l;
		frame = f;
		masses = new HashMap<AdvancedSet<T>, Double>();
	}
	
	public String getLabel() {
		return label;
	}
	
	public AdvancedSet<T> getFrame() {
		return frame;
	}
	
	public Map<AdvancedSet<T>, Double> getMasses() {
		return masses;
	}
	
	public AdvancedSet<AdvancedSet<T>> getFocalSets() {
		AdvancedSet<AdvancedSet<T>> focalSets = new AdvancedSet<AdvancedSet<T>>();
		for(Map.Entry<AdvancedSet<T>, Double> entry : masses.entrySet()) {
			focalSets.add(entry.getKey());
		}
		return focalSets;
	}
	
	public void addMass(AdvancedSet<T> subset, double value) {
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("The mass value must be in the range [0, 1].");
		}
		if(!subset.subsetOf(frame)) {
			throw new IllegalArgumentException("The input must be a subset of the frame of discernment.");
		}
		if(value == 0) {
			masses.remove(subset);
		} else {
			masses.put(subset, value);
		}
	}
	
	public double getMass(AdvancedSet<T> subset) {
        double result = 0;
        if(masses.containsKey(subset)) {
        	result = masses.get(subset);
        }
        return result;
    }
	
	public double getBelief(AdvancedSet<T> subset) {
		double sum = 0;
        for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
        	AdvancedSet<T> subsetFocal = outer.getKey();
        	if(subsetFocal.subsetOf(subset)) {
        		double mass = outer.getValue();
        		sum += mass;
        	}
        }
        return sum;
    }
	
	public double getPlausibility(AdvancedSet<T> subset) {
		double sum = 0;
        for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
        	AdvancedSet<T> subsetFocal = outer.getKey();
        	if(subset.intersects(subsetFocal)) {
    			double mass = outer.getValue();
    			sum += mass;
    		}
        }
        return sum;
    }
	
	public boolean isValid() {
		boolean result = false;
		double sum = sum();
		double deviation = 1e-10;
		if(sum >= 1 - deviation && sum <= 1 + deviation) {
			result = true;
		}
		return result;
	}
	
	public double sum() {
		double sum = 0;
		for(Map.Entry<AdvancedSet<T>, Double> entry : masses.entrySet()) {
			sum += entry.getValue();
		}
		return sum;
	}
	
	public boolean isCommensurable(BBA<T> other) {
		return this.getFrame().equals(other.getFrame());
	}
	
	public double getNonspecificity() {
		double sum = 0;
		for(Map.Entry<AdvancedSet<T>, Double> entry : masses.entrySet()) {
			AdvancedSet<T> focalSet = entry.getKey();
			sum += entry.getValue() * Math.log(focalSet.size()) / Math.log(2);
		}
		return sum;
	}
	
	public double getStrife() {
		double sum = 0;
		for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
			double innerSum = 0;
			AdvancedSet<T> focalSetA = outer.getKey();
			for(Map.Entry<AdvancedSet<T>, Double> inner : masses.entrySet()) {
				AdvancedSet<T> focalSetB = inner.getKey();
				AdvancedSet<T> intersection = focalSetA.intersection(focalSetB);
				innerSum += inner.getValue() * ((double)intersection.size() / (double)focalSetA.size());
			}
			sum += outer.getValue() * Math.log(innerSum) / Math.log(2);
		}
		return -sum;
	}
	
	public double getConflict(BBA<T> other) {
		double sum = 0;
		if(this.isCommensurable(other)) {
			for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
				AdvancedSet<T> focalSetA = outer.getKey();
				for(Map.Entry<AdvancedSet<T>, Double> inner : other.getMasses().entrySet()) {
					AdvancedSet<T> focalSetB = inner.getKey();
					AdvancedSet<T> intersection = focalSetA.intersection(focalSetB);
					if(intersection.size() == 0) {
						sum += (inner.getValue() * outer.getValue());
					}
				}
			}
		}
		return sum;
	}
	
	public double getNormalizationConstant(BBA<T> other) {
		return (double)1 / ((double)1 - this.getConflict(other));
	}
	
	public BBA<T> getConjunctiveMerge(BBA<T> other) {
		BBA<T> merged = null;
		if(this.isCommensurable(other)) {
			merged = new BBA<T>(this.getLabel() + " && " + other.getLabel(), frame);
			double c = getNormalizationConstant(other);
			Map<AdvancedSet<T>, Double> sums = new HashMap<AdvancedSet<T>, Double>();
			for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
				AdvancedSet<T> focalSetA = outer.getKey();
				for(Map.Entry<AdvancedSet<T>, Double> inner : other.getMasses().entrySet()) {
					AdvancedSet<T> focalSetB = inner.getKey();
					if(focalSetA.intersects(focalSetB)) {
						AdvancedSet<T> intersection = focalSetA.intersection(focalSetB);
						double totalMass = c * outer.getValue() * inner.getValue();
						if(sums.containsKey(intersection)) {
							totalMass += sums.get(intersection);
						}
						sums.put(intersection, totalMass);
					}
				}
			}
			for(Map.Entry<AdvancedSet<T>, Double> entry : sums.entrySet()) {
				merged.addMass(entry.getKey(), entry.getValue());
			}
		}
		return merged;
	}
	
	public BBA<T> getDisjunctiveMerge(BBA<T> other) {
		BBA<T> merged = null;
		if(isCommensurable(other)) {
			merged = new BBA<T>(this.getLabel() + " || " + other.getLabel(), frame);
			Map<AdvancedSet<T>, Double> sums = new HashMap<AdvancedSet<T>, Double>();
			for(Map.Entry<AdvancedSet<T>, Double> outer : masses.entrySet()) {
				AdvancedSet<T> focalSetA = outer.getKey();
				for(Map.Entry<AdvancedSet<T>, Double> inner : other.getMasses().entrySet()) {
					AdvancedSet<T> focalSetB = inner.getKey();
					AdvancedSet<T> union = focalSetA.union(focalSetB);
					double totalMass = outer.getValue() * inner.getValue();
					if(sums.containsKey(union)) {
						totalMass += sums.get(union);
					}
					sums.put(union, totalMass);
				}
			}
			for(Map.Entry<AdvancedSet<T>, Double> entry : sums.entrySet()) {
				merged.addMass(entry.getKey(), entry.getValue());
			}
		}
		return merged;
	}
	
	public double getEuclideanDistance(BBA<T> other) {
		double sum = 0;
		if(isCommensurable(other)) {
			AdvancedSet<AdvancedSet<T>> focalSets = this.getFocalSets();
			focalSets.addAll(other.getFocalSets());
			
			for(AdvancedSet<T> focalSet : focalSets) {
				sum += Math.pow(Math.abs(this.getMass(focalSet) - other.getMass(focalSet)), 2);
			}
		}
		return Math.sqrt(sum);
	}
	
	public double getJousselmeDistance(BBA<T> other) {
		double sum = 0;
		if(isCommensurable(other)) {
			AdvancedSet<AdvancedSet<T>> focalSets = this.getFocalSets();
			focalSets.addAll(other.getFocalSets());
			
			Map<AdvancedSet<T>, Double> distances = new HashMap<AdvancedSet<T>, Double>();
			for(AdvancedSet<T> focalSet : focalSets) {
				distances.put(focalSet, this.getMass(focalSet) - other.getMass(focalSet));
			}
			
			Map<AdvancedSet<T>, Double> intermediates = new HashMap<AdvancedSet<T>, Double>();
			for(AdvancedSet<T> column : focalSets) {
				for(AdvancedSet<T> row : focalSets) {
					AdvancedSet<T> intersection = column.intersection(row);
					AdvancedSet<T> union = column.union(row);
					double dab = 0;
					if(!union.isEmpty()) {
						dab = (double)intersection.size() / (double)union.size();
					}
					double value = distances.get(row) * dab;
					if(intermediates.containsKey(column)) {
						value += intermediates.get(column);
					}
					intermediates.put(column, value);
				}
			}
			
			for(AdvancedSet<T> focalSet : focalSets) {
				sum += distances.get(focalSet) * intermediates.get(focalSet);
			}
		}
		return Math.sqrt(0.5 * sum);
	}
	
	public ProbabilityDistribution<T> getPignisticTransformation() {
		ProbabilityDistribution<T> result = new ProbabilityDistribution<T>(frame);
		for(T element : frame) {
			double sum = 0;
			for(Map.Entry<AdvancedSet<T>, Double> entry : masses.entrySet()) {
				AdvancedSet<T> focalSet = entry.getKey();
				if(focalSet.contains(element)) {
					sum += (entry.getValue() / (double)focalSet.size());
				}
			}
			result.addProbability(element, sum);
		}
		return result;
	}
	
	@Override
	public String toString() {
//		String output = "{";
//		String delim = "";
//        for(Map.Entry<AdvancedSet<T>, Double> entry : masses.entrySet()) {
//        	output += delim + "m(";
//        	if(entry.getKey().equals(frame)) {
//        		output += "...";
//        	} else {
//        		output += entry.getKey().toString();
//        	}
//        	output += ")=" + Utilities.format(entry.getValue());
//        	delim = ", ";
//        }
//        output += "}";
//        return output;
		return label;
	}

}
