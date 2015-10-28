package context_dependent;

import java.text.DecimalFormat;

public class Utilities {
	
	public static double DEVIATION = 0.00000001;
	
	private static DecimalFormat formatter = new DecimalFormat("#.###");
	
	public static String format(double d) {
		return formatter.format(d);
	}
	
}
