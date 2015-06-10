package merging_evidence;

import java.text.DecimalFormat;

public class Utilities {
	
	private static DecimalFormat formatter = new DecimalFormat("#.###");
	
	public static String format(double d) {
		return formatter.format(d);
	}
	
}
