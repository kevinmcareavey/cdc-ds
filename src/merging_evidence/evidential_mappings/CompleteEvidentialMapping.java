package merging_evidence.evidential_mappings;

import java.util.HashMap;
import java.util.Map;

import merging_evidence.AdvancedSet;
import merging_evidence.BBA;
import merging_evidence.EvidentialMapping;
import merging_evidence.Pair;
import merging_evidence.Utilities;

public class CompleteEvidentialMapping<T, U> extends EvidentialMapping<T, U> {
	
	private Map<Pair<AdvancedSet<T>, AdvancedSet<U>>, Double> masses;
	
	public CompleteEvidentialMapping(AdvancedSet<T> e, AdvancedSet<U> h) {
		super(e, h);
		masses = new HashMap<Pair<AdvancedSet<T>, AdvancedSet<U>>, Double>();
	}
	
	public Map<Pair<AdvancedSet<T>, AdvancedSet<U>>, Double> getMasses() {
		return masses;
	}
	
	public void addMass(AdvancedSet<T> e, AdvancedSet<U> h, double value) {
		if(value < 0 || value > 1) {
			if(value < 0 && value > 0 - Utilities.DEVIATION) {
				value = (double)0;
			} else if(value > 1 && value < 1 + Utilities.DEVIATION) {
				value = (double)1;
			} else {
				throw new IllegalArgumentException("The mass value must be in the range [0, 1].");
			}
		}
		if(!e.subsetOf(super.getEvidenceFrame())) {
			throw new IllegalArgumentException("The evidence input must be an element of the evidence frame.");
		}
		if(!h.subsetOf(super.getHypothesesFrame())) {
			throw new IllegalArgumentException("The hypotheses input must be a subset of the hypotheses frame.");
		}
		Pair<AdvancedSet<T>, AdvancedSet<U>> pair = new Pair<AdvancedSet<T>, AdvancedSet<U>>(e, h);
		if(value < 0 + Utilities.DEVIATION) {
			masses.remove(pair);
		} else {
			masses.put(pair, value);
		}
	}

	public double getMass(AdvancedSet<T> e, AdvancedSet<U> h) {
		double result = 0;
		Pair<AdvancedSet<T>, AdvancedSet<U>> pair = new Pair<AdvancedSet<T>, AdvancedSet<U>>(e, h);
		if(masses.containsKey(pair)) {
			result = masses.get(pair);
		}
		return result;
	}
	
	public BBA<U> getEvidencePropagation(BBA<T> evidence) {
		Map<AdvancedSet<U>, Double> sums = new HashMap<AdvancedSet<U>, Double>();
		for(Map.Entry<Pair<AdvancedSet<T>, AdvancedSet<U>>, Double> entry : masses.entrySet()) {
			Pair<AdvancedSet<T>, AdvancedSet<U>> pair = entry.getKey();
			AdvancedSet<T> e = pair.getLeft();
			AdvancedSet<U> h = pair.getRight();
			double evidentialMass = entry.getValue();
			double previous = 0;
			if(sums.containsKey(h)) {
				previous = sums.get(h);
			}
			sums.put(h, previous + (evidence.getMass(e) * evidentialMass));
		}
		
		BBA<U> evidencePropagation = new BBA<U>("", super.getHypothesesFrame());
		for(Map.Entry<AdvancedSet<U>, Double> entry : sums.entrySet()) {
			evidencePropagation.addMass(entry.getKey(), entry.getValue());
		}
		
		return evidencePropagation;
	}
	
}
