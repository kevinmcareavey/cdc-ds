package paper;

import java.util.ArrayList;

import merging_evidence.AdvancedSet;
import merging_evidence.BBA;
import merging_evidence.BBASequence;
import merging_evidence.EvidentialMapping;
import merging_evidence.Utilities;

public class Section5 {
	
	private AdvancedSet<Double> sensorFrame;
	private AdvancedSet<String> expertFrame;
	private AdvancedSet<String> agentspeakFrame;
	
	private EvidentialMapping<Double, String> sensorEvidentialMapping;
	private EvidentialMapping<String, String> expertEvidentialMapping;
	
	private BBA<Double> m1;
	private BBA<Double> m2;
	private BBA<Double> m3;
	private BBA<Double> m4;
	private BBA<String> m5;
	private BBA<Double> m6;
	private BBA<Double> m7;
	private BBA<Double> m8;
	private BBA<Double> m9;
	private BBA<String> m10;
	
	private double m1alpha;
	private double m2alpha;
	private double m3alpha;
	private double m4alpha;
	private double m5alpha;
	private double m6alpha;
	private double m7alpha;
	private double m8alpha;
	private double m9alpha;
	private double m10alpha;
	
	private BBASequence<String> sequence;
	
	public Section5() {
		sensorFrame = new AdvancedSet<Double>(48.7, 48.8, 48.9, 49.0, 
				49.1, 49.2, 49.3, 49.4, 49.5, 49.6, 49.7, 49.8, 49.9, 50.0, 
				50.1, 50.2, 50.3, 50.4, 50.5, 50.6, 50.7, 50.8, 50.9, 51.0,
				51.1, 51.2, 51.3);
		expertFrame = new AdvancedSet<String>("normal", "abnormal");
		agentspeakFrame = new AdvancedSet<String>("freq(l)", "freq(n)", "freq(h)");
		
		sensorEvidentialMapping = new EvidentialMapping<Double, String>(sensorFrame, agentspeakFrame);
		sensorEvidentialMapping.addMass(48.7, new AdvancedSet<String>("freq(l)"), 1);
		sensorEvidentialMapping.addMass(48.8, new AdvancedSet<String>("freq(l)"), 1);
		sensorEvidentialMapping.addMass(48.9, new AdvancedSet<String>("freq(l)"), 1);
		sensorEvidentialMapping.addMass(49.0, new AdvancedSet<String>("freq(l)"), 0.75);
		sensorEvidentialMapping.addMass(49.0, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.25);
		sensorEvidentialMapping.addMass(49.1, new AdvancedSet<String>("freq(l)"), 0.5);
		sensorEvidentialMapping.addMass(49.1, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.5);
		sensorEvidentialMapping.addMass(49.2, new AdvancedSet<String>("freq(l)"), 0.25);
		sensorEvidentialMapping.addMass(49.2, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.75);
		sensorEvidentialMapping.addMass(49.3, new AdvancedSet<String>("freq(l)", "freq(n)"), 1);
		sensorEvidentialMapping.addMass(49.4, new AdvancedSet<String>("freq(l)", "freq(n)"), 1);
		sensorEvidentialMapping.addMass(49.5, new AdvancedSet<String>("freq(l)", "freq(n)"), 1);
		sensorEvidentialMapping.addMass(49.6, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.75);
		sensorEvidentialMapping.addMass(49.6, new AdvancedSet<String>("freq(n)"), 0.25);
		sensorEvidentialMapping.addMass(49.7, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.5);
		sensorEvidentialMapping.addMass(49.7, new AdvancedSet<String>("freq(n)"), 0.5);
		sensorEvidentialMapping.addMass(49.8, new AdvancedSet<String>("freq(l)", "freq(n)"), 0.25);
		sensorEvidentialMapping.addMass(49.8, new AdvancedSet<String>("freq(n)"), 0.75);
		sensorEvidentialMapping.addMass(49.9, new AdvancedSet<String>("freq(n)"), 1);
		sensorEvidentialMapping.addMass(50.0, new AdvancedSet<String>("freq(n)"), 1);
		sensorEvidentialMapping.addMass(50.1, new AdvancedSet<String>("freq(n)"), 1);
		sensorEvidentialMapping.addMass(50.2, new AdvancedSet<String>("freq(n)"), 0.75);
		sensorEvidentialMapping.addMass(50.2, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.25);
		sensorEvidentialMapping.addMass(50.3, new AdvancedSet<String>("freq(n)"), 0.5);
		sensorEvidentialMapping.addMass(50.3, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.5);
		sensorEvidentialMapping.addMass(50.4, new AdvancedSet<String>("freq(n)"), 0.25);
		sensorEvidentialMapping.addMass(50.4, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.75);
		sensorEvidentialMapping.addMass(50.5, new AdvancedSet<String>("freq(n)", "freq(h)"), 1);
		sensorEvidentialMapping.addMass(50.6, new AdvancedSet<String>("freq(n)", "freq(h)"), 1);
		sensorEvidentialMapping.addMass(50.7, new AdvancedSet<String>("freq(n)", "freq(h)"), 1);
		sensorEvidentialMapping.addMass(50.8, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.75);
		sensorEvidentialMapping.addMass(50.8, new AdvancedSet<String>("freq(h)"), 0.25);
		sensorEvidentialMapping.addMass(50.9, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.5);
		sensorEvidentialMapping.addMass(50.9, new AdvancedSet<String>("freq(h)"), 0.5);
		sensorEvidentialMapping.addMass(51.0, new AdvancedSet<String>("freq(n)", "freq(h)"), 0.25);
		sensorEvidentialMapping.addMass(51.0, new AdvancedSet<String>("freq(h)"), 0.75);
		sensorEvidentialMapping.addMass(51.1, new AdvancedSet<String>("freq(h)"), 1);
		sensorEvidentialMapping.addMass(51.2, new AdvancedSet<String>("freq(h)"), 1);
		sensorEvidentialMapping.addMass(51.3, new AdvancedSet<String>("freq(h)"), 1);
		
		expertEvidentialMapping = new EvidentialMapping<String, String>(expertFrame, agentspeakFrame);
		expertEvidentialMapping.addMass("normal", new AdvancedSet<String>("freq(n)"), 1);
		expertEvidentialMapping.addMass("abnormal", new AdvancedSet<String>("freq(l)"), 0.5);
		expertEvidentialMapping.addMass("abnormal", new AdvancedSet<String>("freq(h)"), 0.5);
		
		m1 = new BBA<Double>("m1", sensorFrame);
		m1.setMass(new AdvancedSet<Double>(51.2), 1);
		
		m2 = new BBA<Double>("m2", sensorFrame);
		m2.setMass(new AdvancedSet<Double>(51.1, 51.2, 51.3), 1);
		
		m3 = new BBA<Double>("m3", sensorFrame);
		m3.setMass(new AdvancedSet<Double>(51.3), 1);
		
		m4 = new BBA<Double>("m4", sensorFrame);
		m4.setMass(new AdvancedSet<Double>(50.9, 51.0, 51.1, 51.2, 51.3), 1);
		
		m5 = new BBA<String>("m5", expertFrame);
		m5.setMass(new AdvancedSet<String>("abnormal"), 0.9);
		m5.setMass(expertFrame, 0.1);
		
		m6 = new BBA<Double>("m6", sensorFrame);
		m6.setMass(new AdvancedSet<Double>(50.8, 50.9, 51.0, 51.1, 51.2), 1);
		
		m7 = new BBA<Double>("m7", sensorFrame);
		m7.setMass(new AdvancedSet<Double>(50.8, 50.9, 51.0), 1);
		
		m8 = new BBA<Double>("m8", sensorFrame);
		m8.setMass(new AdvancedSet<Double>(51.1), 1);
		
		m9 = new BBA<Double>("m9", sensorFrame);
		m9.setMass(new AdvancedSet<Double>(51.0, 51.1, 51.2), 1);
		
		m10 = new BBA<String>("m10", expertFrame);
		m10.setMass(new AdvancedSet<String>("abnormal"), 0.75);
		m10.setMass(expertFrame, 0.25);
		
		m1alpha = 0.02;
		m2alpha = 0.3;
		m3alpha = 0.08;
		m4alpha = 0.25;
		m5alpha = 0.15;
		m6alpha = 0.2;
		m7alpha = 0.04;
		m8alpha = 0.1;
		m9alpha = 0.05;
		m10alpha = 0.35;
		
		sequence = new BBASequence<String>(agentspeakFrame);
	}
	
	public void table5() {
		System.out.println(sensorEvidentialMapping);
		System.out.println(expertEvidentialMapping);
	}
	
	public void table6b() throws Exception {
		System.out.println(m1 + " (\\alpha=" + m1alpha + ") => " + m1.getDiscountedBBA(m1alpha));
		System.out.println(m2 + " (\\alpha=" + m2alpha + ") => " + m2.getDiscountedBBA(m2alpha));
		System.out.println(m3 + " (\\alpha=" + m3alpha + ") => " + m3.getDiscountedBBA(m3alpha));
		System.out.println(m4 + " (\\alpha=" + m4alpha + ") => " + m4.getDiscountedBBA(m4alpha));
		System.out.println(m5 + " (\\alpha=" + m5alpha + ") => " + m5.getDiscountedBBA(m5alpha));
		System.out.println(m6 + " (\\alpha=" + m6alpha + ") => " + m6.getDiscountedBBA(m6alpha));
		System.out.println(m7 + " (\\alpha=" + m7alpha + ") => " + m7.getDiscountedBBA(m7alpha));
		System.out.println(m8 + " (\\alpha=" + m8alpha + ") => " + m8.getDiscountedBBA(m8alpha));
		System.out.println(m9 + " (\\alpha=" + m9alpha + ") => " + m9.getDiscountedBBA(m9alpha));
		System.out.println(m10 + " (\\alpha=" + m10alpha + ") => " + m10.getDiscountedBBA(m10alpha));
	}
	
	public void table6c() throws Exception {
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m1.getDiscountedBBA(m1alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m2.getDiscountedBBA(m2alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m3.getDiscountedBBA(m3alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m4.getDiscountedBBA(m4alpha)));
		sequence.add(expertEvidentialMapping.getEvidencePropagation(m5.getDiscountedBBA(m5alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m6.getDiscountedBBA(m6alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m7.getDiscountedBBA(m7alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m8.getDiscountedBBA(m8alpha)));
		sequence.add(sensorEvidentialMapping.getEvidencePropagation(m9.getDiscountedBBA(m9alpha)));
		sequence.add(expertEvidentialMapping.getEvidencePropagation(m10.getDiscountedBBA(m10alpha)));
		
		for(BBA<String> bba : sequence) {
			System.out.println(bba);
		}
	}
	
	public void table7a() {
		for(BBA<String> bba : sequence) {
			System.out.println("N(" + bba.getLabel() + ")=" + Utilities.format(bba.getNonspecificity()) 
					+ ", S(" + bba.getLabel() + ")=" + Utilities.format(bba.getStrife()));
		}
	}
	
	public void table7b() throws Exception {
		ArrayList<BBA<String>> references = new ArrayList<BBA<String>>();
		BBA<String> combine = sequence.get(0);
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(2));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(7));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(8));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(1));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(3));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(5));
		references.add(combine);
		combine = combine.getDempstersCombination(sequence.get(6));
		references.add(combine);
		
		for(BBA<String> reference : references) {
			String delim = "";
			for(BBA<String> bba : sequence) {
				System.out.print(delim + "d(" + reference.getLabel() + ", " + bba.getLabel() + ")=" + Utilities.format(reference.getJousselmeDistance(bba)));
				delim = ", ";
			}
			System.out.println();
		}
		
		System.out.println("K(" + references.get(0).getLabel() + ", " + sequence.get(2).getLabel() + ")=" + Utilities.format(references.get(0).getConflict(sequence.get(2))));
		System.out.println("K(" + references.get(1).getLabel() + ", " + sequence.get(7).getLabel() + ")=" + Utilities.format(references.get(1).getConflict(sequence.get(7))));
		System.out.println("K(" + references.get(2).getLabel() + ", " + sequence.get(8).getLabel() + ")=" + Utilities.format(references.get(2).getConflict(sequence.get(8))));
		System.out.println("K(" + references.get(3).getLabel() + ", " + sequence.get(1).getLabel() + ")=" + Utilities.format(references.get(3).getConflict(sequence.get(1))));
		System.out.println("K(" + references.get(4).getLabel() + ", " + sequence.get(3).getLabel() + ")=" + Utilities.format(references.get(4).getConflict(sequence.get(3))));
		System.out.println("K(" + references.get(5).getLabel() + ", " + sequence.get(5).getLabel() + ")=" + Utilities.format(references.get(5).getConflict(sequence.get(5))));
		System.out.println("K(" + references.get(6).getLabel() + ", " + sequence.get(6).getLabel() + ")=" + Utilities.format(references.get(6).getConflict(sequence.get(6))));
		System.out.println("K(" + references.get(7).getLabel() + ", " + sequence.get(4).getLabel() + ")=" + Utilities.format(references.get(7).getConflict(sequence.get(4))));
		System.out.println("K(" + sequence.get(4).getLabel() + ", " + sequence.get(9).getLabel() + ")=" + Utilities.format(sequence.get(4).getConflict(sequence.get(9))));
	}
	
	public void table8a() throws Exception {
		System.out.println(sequence.getContextDependentCombination(0.3));
		System.out.println(sequence.getBBASet().getDempstersCombination());
		System.out.println(sequence.getBBASet().getDuboisAndPradesCombination());
	}
	
	public void table8b() throws Exception {
		System.out.println(sequence.getContextDependentCombination(0.3).getPignisticTransformation());
		System.out.println(sequence.getBBASet().getDempstersCombination().getPignisticTransformation());
		System.out.println(sequence.getBBASet().getDuboisAndPradesCombination().getPignisticTransformation());
	}
	
	public static void main(String[] args) {
		try {
			Section5 section5 = new Section5();
			section5.table5();
			section5.table6b();
			section5.table6c();
			section5.table7a();
			section5.table7b();
			section5.table8a();
			section5.table8b();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
