package merging_evidence;

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
	
	public BBA<T> getReferenceBBA() throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		BBA<T> best = null;
		double bestNonspecificity = Double.NEGATIVE_INFINITY;
		double bestStrife = Double.POSITIVE_INFINITY;
		for(BBA<T> current : bbas) {
			double currentNonspecificity = current.getNonspecificity();
			double currentStrife = current.getStrife();
			if((best == null) || (currentNonspecificity < bestNonspecificity) 
					|| ((currentNonspecificity == bestNonspecificity) && (currentStrife < bestStrife))) {
				best = current;
				bestNonspecificity = currentNonspecificity;
				bestStrife = currentStrife;
			}
		}
		return best;
	}
	
	public BBA<T> getClosestBBA(BBA<T> target, AdvancedSet<BBA<T>> set) {
		BBA<T> closest = null;
		double closestDistance = Double.POSITIVE_INFINITY;
		for(BBA<T> current : set) {
			double currentDistance = target.getJousselmeDistance(current);
			if((closest == null) || (currentDistance < closestDistance)) {
				closest = current;
				closestDistance = currentDistance;
			}
		}
		return closest;
	}
	
	public BBA<T> getConjunctiveMerge() throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		BBA<T> merge = this.getReferenceBBA();
		copy.remove(merge);
		
		while(!copy.isEmpty()) {
			BBA<T> closest = this.getClosestBBA(merge, copy);
			merge = merge.getConjunctiveMerge(closest);
			copy.remove(closest);
		}
		
		return merge;
	}
	
	public BBA<T> getDisjunctiveMerge() throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		BBA<T> merge = this.getReferenceBBA();
		copy.remove(merge);
		
		while(!copy.isEmpty()) {
			BBA<T> closest = this.getClosestBBA(merge, copy);
			merge = merge.getDisjunctiveMerge(closest);
			copy.remove(closest);
		}
		
		return merge;
	}
	
	public BBA<T> getLPMCSMerge(double strifeThreshold, double conflictThreshold) throws Exception {
		if(bbas.isEmpty()) {
			throw new Exception("Set is empty.");
		}
		
		AdvancedSet<BBA<T>> copy = bbas.copy();
		BBA<T> merge = this.getReferenceBBA();
		copy.remove(merge);
		
		BBASet<T> lpmcses = new BBASet<T>(frame);
		while(!copy.isEmpty()) {
			BBA<T> closest = this.getClosestBBA(merge, copy);
			
			double conflict = merge.getConflict(closest);
			if(conflict <= conflictThreshold) {
				BBA<T> result = merge.getConjunctiveMerge(closest);
				if(result.getStrife() <= strifeThreshold) {
					merge = result;
					copy.remove(closest);
				} else {
					lpmcses.add(merge);
					merge = closest;
					copy.remove(closest);
				}
			} else {
				lpmcses.add(merge);
				merge = closest;
				copy.remove(closest);
			}
		}
		lpmcses.add(merge);
		
		return lpmcses.getDisjunctiveMerge();
	}
	
}
