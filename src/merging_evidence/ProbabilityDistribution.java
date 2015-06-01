package merging_evidence;

import java.util.HashMap;
import java.util.Map;

public class ProbabilityDistribution<T> {
	
	AdvancedSet<T> frame;
	Map<T, Double> probabilities;
	
	public ProbabilityDistribution(AdvancedSet<T> f) {
		frame = f;
		probabilities = new HashMap<T, Double>();
	}
	
	public void addProbability(T element, double value) {
		if(value < 0 || value > 1) {
			throw new IllegalArgumentException("The mass value must be in the range [0, 1].");
		}
		if(!frame.contains(element)) {
			throw new IllegalArgumentException("The input must be an element of the frame of discernment.");
		}
		if(value == 0) {
			probabilities.remove(element);
		} else {
			probabilities.put(element, value);
		}
	}
	
	@Override
	public String toString() {
		String output = "{";
		String delim = "";
		for(Map.Entry<T, Double> entry : probabilities.entrySet()) {
			output += delim + "P(" + entry.getKey() + ")=" + Utilities.format(entry.getValue());
			delim = ", ";
		}
		output += "}";
		return output;
	}

}
