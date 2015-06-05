package merging_evidence;

import java.util.ArrayList;

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
