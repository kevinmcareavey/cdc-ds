package paper;

import java.util.ArrayList;

import merging_evidence.AdvancedSet;
import merging_evidence.BBA;
import merging_evidence.BBASequence;
import merging_evidence.Utilities;

public class Section3 {
	
	private AdvancedSet<String> frame;
	
	private BBA<String> m1;
	private BBA<String> m2;
	private BBA<String> m3;
	
	private BBASequence<String> sequence;
	
	public Section3() {
		frame = new AdvancedSet<String>("a", "b", "c");
		
		m1 = new BBA<String>("m1", frame);
		m1.setMass(new AdvancedSet<String>("a"), 0.85);
		m1.setMass(new AdvancedSet<String>("b", "c"), 0.15);
		
		m2 = new BBA<String>("m2", frame);
		m2.setMass(new AdvancedSet<String>("a"), 0.7);
		m2.setMass(new AdvancedSet<String>("b", "c"), 0.3);
		
		m3 = new BBA<String>("m3", frame);
		m3.setMass(new AdvancedSet<String>("a"), 0.55);
		m3.setMass(new AdvancedSet<String>("b", "c"), 0.45);
		
		sequence = new BBASequence<String>(frame);
		sequence.add(m1);
		sequence.add(m2);
		sequence.add(m3);
	}
	
	public void table1() {
		for(BBA<String> bba : sequence) {
			System.out.println("N(" + bba.getLabel() + ")=" + Utilities.format(bba.getNonspecificity()) 
					+ ", S(" + bba.getLabel() + ")=" + Utilities.format(bba.getStrife()));
		}
	}
	
	public void table2() throws Exception {
		ArrayList<BBA<String>> references = new ArrayList<BBA<String>>();
		references.add(m1);
		references.add(m2);
		references.add(m3);
		references.add(m1.getDempstersCombination(m2));
		references.add(m1.getDempstersCombination(m3));
		references.add(m2.getDempstersCombination(m3));
		
		for(BBA<String> reference : references) {
			String delim = "";
			for(BBA<String> bba : sequence) {
				System.out.print(delim + "d(" + reference.getLabel() + ", " + bba.getLabel() + ")=" + Utilities.format(reference.getJousselmeDistance(bba)));
				delim = ", ";
			}
			System.out.println();
		}
		
		for(BBA<String> reference : references) {
			String delim = "";
			for(BBA<String> bba : sequence) {
				System.out.print(delim + "K(" + reference.getLabel() + ", " + bba.getLabel() + ")=" + Utilities.format(reference.getConflict(bba)));
				delim = ", ";
			}
			System.out.println();
		}
	}
	
	public void example4() throws Exception {
		System.out.println(sequence.getContextDependentCombination(0.4).getLabel());
	}
	
	public void table3() throws Exception {
		double threshold = 0.4;
		System.out.println("Context-dependent (" + threshold + "): " + sequence.getContextDependentCombination(threshold));
		System.out.println("Dempster's rule (" + threshold + "): " + sequence.getBBASet().getDempstersCombination());
		System.out.println("Dubois & Prade's rule (" + threshold + "): " + sequence.getBBASet().getDuboisAndPradesCombination());
	}
	
	public static void main(String[] args) {
		try {
			Section3 section3 = new Section3();
			section3.table1();
			section3.table2();
			section3.example4();
			section3.table3();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
