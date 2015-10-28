package merging_evidence;

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
	
	public BBA<T> getDempstersCombination() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		}
		
		BBA<T> reference = null;
		for(BBA<T> next : this) {
			if(reference == null) {
				reference = next;
			} else {
				reference = reference.getDempstersCombination(next);
			}
		}
		
		return reference;
	}
	
	public BBA<T> getDuboisAndPradesCombination() throws Exception {
		if(this.isEmpty()) {
			throw new Exception("No BBAs to merge.");
		}
		
		BBA<T> reference = null;
		for(BBA<T> next : this) {
			if(reference == null) {
				reference = next;
			} else {
				reference = reference.getDuboisAndPradesCombination(next);
			}
		}
		
		return reference;
	}
	
	public BBASet<T> copy() {
		BBASet<T> copy = new BBASet<T>(frame);
		copy.addAll(this);
		return copy;
	}
	
	@Override
	public String toString() {
		AdvancedSet<String> output = new AdvancedSet<String>();
		for(BBA<T> element : this) {
			output.add(element.getLabel());
		}
		return output.toString();
	}
	
}
