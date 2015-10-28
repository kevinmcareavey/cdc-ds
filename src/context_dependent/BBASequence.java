package context_dependent;

import java.util.ArrayList;
import java.util.Comparator;

public class BBASequence<T> extends ArrayList<BBA<T>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8455598628093022627L;
	
	private AdvancedSet<T> frame;
	
	public BBASequence(AdvancedSet<T> f) {
		frame = f;
	}
	
	public BBASequence(BBASet<T> set) {
		frame = set.getFrame();
		this.addAll(set);
	}
	
	public BBASequence<T> copy() {
		BBASequence<T> copy = new BBASequence<T>(frame);
		copy.addAll(this);
		return copy;
	}
	
	public BBASet<T> getBBASet() {
		BBASet<T> set = new BBASet<T>(frame);
		set.addAll(this);
		return set;
	}
	
	public BBA<T> getClosestBBA(BBA<T> reference) throws Exception {
		if(this.isEmpty()) {
			throw new Exception("sequence is empty");
		} else {
			BBA<T> closest = this.get(0);
			double closestDistance = closest.getJousselmeDistance(reference);
			if(this.size() > 1) {
				for(int i = 1; i < this.size(); i++) {
					BBA<T> next = this.get(i);
					double nextDistance = next.getJousselmeDistance(reference);
					if(nextDistance < closestDistance) {
						closest = next;
						closestDistance = nextDistance;
					}
				}
			}
			return closest;
		}
	}
	
	public BBA<T> getContextDependentCombination(double conflictThreshold) throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		} else {
			BBASequence<T> preferenceOrder = this.copy();
			
			BBASet<T> lpmcses = new BBASet<T>(frame);
			
			BBASequence<T> qualityOrder = preferenceOrder.copy();
			qualityOrder.sort(new HeuristicComparator<T>());
			
			BBA<T> reference = qualityOrder.remove(0);
			preferenceOrder.remove(reference);
			
			while(!preferenceOrder.isEmpty()) {
				BBA<T> closest = preferenceOrder.getClosestBBA(reference);
				if(reference.getConflict(closest) <= conflictThreshold) {
					reference = reference.getDempstersCombination(closest);
					qualityOrder.remove(closest);
					preferenceOrder.remove(closest);
				} else {
					lpmcses.add(reference);
					reference = qualityOrder.remove(0);
					preferenceOrder.remove(reference);
				}
			}
			
			if(!qualityOrder.isEmpty()) {
				throw new Exception("Inconsistent removal of BBAs.");
			}
			
			for(BBA<T> lpmcs : lpmcses) {
				reference = reference.getDuboisAndPradesCombination(lpmcs);
			}
			
			return reference;
		}
	}
	
	@Override
	public String toString() {
		String output = "(";
		String delim = "";
		for(BBA<T> element : this) {
			output += delim + element.getLabel();
			delim = ", ";
		}
		output += ")";
		return output;
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
