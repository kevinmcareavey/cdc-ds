package merging_evidence;

import java.util.ArrayList;
import java.util.List;

public class BBASet<T> {
	
	private AdvancedSet<T> frame;
	private AdvancedSet<BBA<T>> bbas;
	
	public BBASet(AdvancedSet<T> f) {
		frame = f;
		bbas = new AdvancedSet<BBA<T>>();
	}
	
	public void add(BBA<T> bba) {
		if(!bba.getFrame().equals(frame)) {
			throw new IllegalArgumentException("All BBAs in set must share the same frame.");
		}
		bbas.add(bba);
	}
	
	public List<BBA<T>> getHeuristicRanking(AdvancedSet<BBA<T>> set) {
		List<BBA<T>> ranking = new ArrayList<BBA<T>>();
		ranking.addAll(set);
		
		int n = ranking.size();
        int k;
        for(int m = n; m >= 0; m--) {
            for(int i = 0; i < n - 1; i++) {
                k = i + 1;
                BBA<T> first = ranking.get(i);
                BBA<T> second = ranking.get(k);
                if((second.getNonspecificity() < first.getNonspecificity())
                		|| (second.getNonspecificity() == first.getNonspecificity() && second.getStrife() < first.getStrife())) {
                	ranking.set(i, second);
                	ranking.set(k, first);
                }
            }
        }
        
		return ranking;
	}
	
	public List<BBA<T>> getDistanceRanking(BBA<T> ref, AdvancedSet<BBA<T>> set) {
		List<BBA<T>> ranking = new ArrayList<BBA<T>>();
		ranking.addAll(set);
		
		int n = ranking.size();
        int k;
        for(int m = n; m >= 0; m--) {
            for(int i = 0; i < n - 1; i++) {
                k = i + 1;
                BBA<T> first = ranking.get(i);
                BBA<T> second = ranking.get(k);
                if(ref.getJousselmeDistance(second) < ref.getJousselmeDistance(first)) {
                	ranking.set(i, second);
                	ranking.set(k, first);
                }
            }
        }
		
		return ranking;
	}
	
	public BBA<T> getConjunctiveMerge() throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		BBA<T> reference = this.getHeuristicRanking(copy).get(0);
		System.err.println("heuristic := " + this.getHeuristicRanking(copy));
		copy.remove(reference);
		List<BBA<T>> distanceRanking = this.getDistanceRanking(reference, copy);
		System.err.println("distance(" + reference + ") := " + distanceRanking);
		for(BBA<T> next : distanceRanking) {
			reference = reference.getConjunctiveMerge(next);
		}
		
		return reference;
	}
	
	public BBA<T> getDisjunctiveMerge() throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		BBA<T> reference = this.getHeuristicRanking(copy).get(0);
		System.err.println("heuristic := " + this.getHeuristicRanking(copy));
		copy.remove(reference);
		List<BBA<T>> distanceRanking = this.getDistanceRanking(reference, copy);
		System.err.println("distance(" + reference + ") := " + distanceRanking);
		for(BBA<T> next : distanceRanking) {
			reference = reference.getDisjunctiveMerge(next);
		}
		
		return reference;
	}
	
	public BBA<T> getLPMCSMerge(double strifeThreshold, double conflictThreshold) throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		
		List<BBA<T>> heuristicRanking = this.getHeuristicRanking(copy);
		System.err.println("heuristic := " + heuristicRanking);
		
		BBA<T> reference = heuristicRanking.remove(0);
		System.err.println("new reference is " + reference + "...");
		
		copy.remove(reference);
		List<BBA<T>> distanceRanking = this.getDistanceRanking(reference, copy);
		System.err.println("distance(" + reference + ") := " + distanceRanking);
		
		BBASet<T> lpmcses = new BBASet<T>(frame);
		while(!distanceRanking.isEmpty()) {
			BBA<T> next = distanceRanking.get(0);
			if(reference.getConflict(next) <= conflictThreshold) {
				BBA<T> merge = reference.getConjunctiveMerge(next);
				if(merge.getStrife() <= strifeThreshold) {
					reference = merge;
					System.err.println("new reference is " + reference + "...");
					copy.remove(next);
					heuristicRanking.remove(next);
					System.err.println("heuristic := " + heuristicRanking);
					distanceRanking.remove(0);
				} else {
					System.err.println("adding " + reference + " to LPMCSes...");
					lpmcses.add(reference);
					reference = heuristicRanking.remove(0);
					System.err.println("new reference is " + reference + "...");
					System.err.println("heuristic := " + heuristicRanking);
					copy.remove(reference);
					distanceRanking = this.getDistanceRanking(reference, copy);
					System.err.println("distance(" + reference + ") := " + distanceRanking);
				}
			} else {
				System.err.println("adding " + reference + " to LPMCSes...");
				lpmcses.add(reference);
				reference = heuristicRanking.remove(0);
				System.err.println("new reference is " + reference + "...");
				System.err.println("heuristic := " + heuristicRanking);
				copy.remove(reference);
				distanceRanking = this.getDistanceRanking(reference, copy);
				System.err.println("distance(" + reference + ") := " + distanceRanking);
			}
		}
		System.err.println("adding " + reference + " to LPMCSes...");
		lpmcses.add(reference);
		
		return lpmcses.getDisjunctiveMerge();
	}
	
}
