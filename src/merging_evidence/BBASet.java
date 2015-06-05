package merging_evidence;

import java.util.Comparator;

public class BBASet<T> extends AdvancedSet<BBA<T>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5303323634277871248L;
	
	private AdvancedSet<T> frame;
	
	public BBASet(AdvancedSet<T> f) {
		frame = f;
	}
	
	public AdvancedSet<T> getFrame() {
		return frame;
	}
	
	@Override
	public boolean add(BBA<T> bba) {
		if(!bba.getFrame().equals(frame)) {
			throw new IllegalArgumentException("All BBAs in set must share the same frame.");
		}
		return super.add(bba);
	}
	
	public BBA<T> getConjunctiveMerge() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		}
		
		BBA<T> reference = null;
		for(BBA<T> next : this) {
			if(reference == null) {
				reference = next;
			} else {
				reference = reference.getConjunctiveMerge(next);
			}
		}
		
		return reference;
	}
	
	public BBA<T> getDisjunctiveMerge() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		}
		
		BBA<T> reference = null;
		for(BBA<T> next : this) {
			if(reference == null) {
				reference = next;
			} else {
				reference = reference.getDisjunctiveMerge(next);
			}
		}
		
		return reference;
	}
	
	public BBA<T> getLPMCSMerge(double strifeThreshold, double conflictThreshold) throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		}
		
		BBASequence<T> heuristicRanking = new BBASequence<T>(this);
		heuristicRanking.sort(new HeuristicComparator<T>());
		BBA<T> reference = heuristicRanking.remove(0);
		
		BBASequence<T> distanceRanking = heuristicRanking.copy();
		distanceRanking.sort(new DistanceComparator<T>(reference));
		
		BBASet<T> lpmcses = new BBASet<T>(frame);
		while(!distanceRanking.isEmpty()) {
			BBA<T> next = distanceRanking.get(0);
			if(reference.getConflict(next) <= conflictThreshold) {
				BBA<T> merge = reference.getConjunctiveMerge(next);
				if(merge.getStrife() <= strifeThreshold) {
					reference = merge;
					heuristicRanking.remove(next);
					distanceRanking.remove(0);
				} else {
					lpmcses.add(reference);
					reference = heuristicRanking.remove(0);
					distanceRanking.remove(reference);
					distanceRanking.sort(new DistanceComparator<T>(reference));
				}
			} else {
				lpmcses.add(reference);
				reference = heuristicRanking.remove(0);
				distanceRanking.remove(reference);
				distanceRanking.sort(new DistanceComparator<T>(reference));
			}
		}
		lpmcses.add(reference);
		
		return lpmcses.getDisjunctiveMerge();
	}
	
}

class HeuristicComparator<T> implements Comparator<BBA<T>> {
	
    public int compare(BBA<T> a, BBA<T> b) {
    	double aNonspecificity = a.getNonspecificity();
    	double bNonspecificity = b.getNonspecificity();
    	double aStrife = a.getStrife();
    	double bStrife = b.getStrife();
		if((aNonspecificity < bNonspecificity) 
				|| (aNonspecificity == bNonspecificity && aStrife < bStrife)) {
			return -1;
		} else if((aNonspecificity == bNonspecificity) 
				&& (aStrife == bStrife)) {
			return 0;
		} else {
			return 1;
		}
    }
    
}

class DistanceComparator<T> implements Comparator<BBA<T>> {
	
	private BBA<T> reference;
	
	public DistanceComparator(BBA<T> r) {
		reference = r;
	}
	
    public int compare(BBA<T> a, BBA<T> b) {
    	double aDistance = reference.getJousselmeDistance(a);
    	double bDistance = reference.getJousselmeDistance(b);
		if(aDistance < bDistance) {
			return -1;
		} else if(aDistance == bDistance) {
			return 0;
		} else {
			return 1;
		}
    }
    
}
