package merging_evidence;

import java.util.HashMap;
import java.util.Map;

public class ProbabilityDistribution<T> extends HashMap<T, Double> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378472408271493264L;
	
	private AdvancedSet<T> frame;
	
	public ProbabilityDistribution(AdvancedSet<T> f) {
		frame = f;
	}
	
	@Override
	public Double put(T element, Double value) {
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("The mass value must be in the range [0, 1].");
		}
		if(!frame.contains(element)) {
			throw new IllegalArgumentException("The input must be an element of the frame of discernment.");
		}
		if(value == 0) {
			return super.remove(element);
		} else {
			return super.put(element, value);
		}
	}
	
	@Override
	public Double get(Object element) {
		if(!frame.contains(element)) {
			throw new IllegalArgumentException("The input must be an element of the frame of discernment.");
		}
		if(super.containsKey(element)) {
			return super.get(element);
		} else {
			return 0.0;
		}
	}
	
	@Override
	public String toString() {
		String output = "{";
		String delim = "";
		for(Map.Entry<T, Double> entry : this.entrySet()) {
			output += delim + "P(" + entry.getKey() + ")=" + Utilities.format(entry.getValue());
			delim = ", ";
		}
		output += "}";
		return output;
	}

}
