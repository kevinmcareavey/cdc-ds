package merging_evidence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BBASequence<T> {
	
	private AdvancedSet<T> frame;
	private List<BBA<T>> sequence;
	
	public BBASequence(AdvancedSet<T> f) {
		frame = f;
		sequence = new ArrayList<BBA<T>>();
	}
	
	public void add(BBA<T> bba) {
		if(!bba.getFrame().equals(frame)) {
			throw new IllegalArgumentException("All BBAs in sequence must share the same frame.");
		}
		sequence.add(bba);
	}

	public BBA<T> getLPMCSMerge(double strifeThreshold, double conflictThreshold) {
		List<BBA<T>> conjunctive_merges = new ArrayList<BBA<T>>();
		if(sequence.size() > 1) {       
			BBA<T> best = sequence.get(0);

			for(int i = 1; i < sequence.size(); i++) {
				double bestNonspecificity = best.getNonspecificity();
				double currentNonspecificity = sequence.get(i).getNonspecificity();

				if(bestNonspecificity <= currentNonspecificity) {                                     
					if((bestNonspecificity == currentNonspecificity) && (sequence.get(i).getStrife() < best.getStrife())) {               
						best = sequence.get(i);
					}
				} else {
					best = sequence.get(i);
				}
			}
			sequence.remove(best);
			
			Map<BBA<T>, Double> distances = new HashMap<BBA<T>, Double>();
			for(int i = 0; i < sequence.size(); i++) {
				BBA<T> bba = sequence.get(i);
				distances.put(bba, best.getJousselmeDistance(bba));
			}

			BBA<T> merged = best;

			boolean thresholds_valid = true;
			
			while(thresholds_valid && !distances.isEmpty()) {
				Map.Entry<BBA<T>, Double> closest = null; 
				for(Map.Entry<BBA<T>, Double> distance : distances.entrySet()) {
					if(closest == null) {
						closest = distance;
					} else {
						if(distance.getValue() < closest.getValue()) {
							closest = distance;
						}
					}
				}
				
				distances.remove(closest.getKey());        
				
				double K = merged.getConflict(closest.getKey());

				if(K <= conflictThreshold) {
					BBA<T> result = merged.getConjunctiveMerge(closest.getKey());
					if(result.getStrife() <= strifeThreshold) {
						sequence.remove(closest.getKey());
						merged = result;
					} else {
						thresholds_valid = false;
					}
				} else {
					thresholds_valid = false;
				}
			}
			
			conjunctive_merges.add(merged);
		} else {
			conjunctive_merges.add(sequence.get(0));
		}
		BBA<T> lpmcs = conjunctive_merges.get(0);
		for(int i = 1; i < conjunctive_merges.size(); i++) {
			lpmcs = lpmcs.getConjunctiveMerge(conjunctive_merges.get(i));
		}
		return lpmcs;
	}
	
}
