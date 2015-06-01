package merging_evidence;

public class Debug {
	
	public static void example() {
		AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");
		
		BBA<String> m1 = new BBA<String>(frame);
		m1.addMass(new AdvancedSet<String>("l"), 0.05);
		m1.addMass(new AdvancedSet<String>("n"), 0.95);
		
		BBA<String> m2 = new BBA<String>(frame);
		m2.addMass(new AdvancedSet<String>("l"), 0.22);
		m2.addMass(new AdvancedSet<String>("n"), 0.78);
		
		BBA<String> m3 = new BBA<String>(frame);
		m3.addMass(new AdvancedSet<String>("l"), 0.56);
		m3.addMass(new AdvancedSet<String>("n"), 0.44);
		
		BBA<String> m4 = new BBA<String>(frame);
		m4.addMass(new AdvancedSet<String>("l"), 0.05);
		m4.addMass(new AdvancedSet<String>("n"), 0.95);
		
		BBA<String> m5 = new BBA<String>(frame);
		m5.addMass(new AdvancedSet<String>("n"), 0.85);
		m5.addMass(new AdvancedSet<String>("h"), 0.15);
		
		BBA<String> m6 = new BBA<String>(frame);
		m6.addMass(new AdvancedSet<String>("n"), 0.85);
		m6.addMass(new AdvancedSet<String>("h"), 0.15);
		
		BBA<String> m7 = new BBA<String>(frame);
		m7.addMass(new AdvancedSet<String>("l"), 0.15);
		m7.addMass(new AdvancedSet<String>("n"), 0.85);
		
		BBA<String> m8 = new BBA<String>(frame);
		m8.addMass(new AdvancedSet<String>("l"), 0.05);
		m8.addMass(new AdvancedSet<String>("n"), 0.95);
		
		BBA<String> m9 = new BBA<String>(frame);
		m9.addMass(new AdvancedSet<String>("l"), 0.15);
		m9.addMass(new AdvancedSet<String>("n"), 0.85);
		
		BBA<String> m10 = new BBA<String>(frame);
		m10.addMass(new AdvancedSet<String>("l"), 0.1);
		m10.addMass(new AdvancedSet<String>("n"), 0.9);
		
		BBA<String> m11 = new BBA<String>(frame);
		m11.addMass(new AdvancedSet<String>("l"), 0.22);
		m11.addMass(new AdvancedSet<String>("n"), 0.78);
		
		BBA<String> m12 = new BBA<String>(frame);
		m12.addMass(new AdvancedSet<String>("l"), 0.22);
		m12.addMass(new AdvancedSet<String>("n"), 0.78);
		
		BBA<String> m13 = new BBA<String>(frame);
		m13.addMass(new AdvancedSet<String>("n"), 0.5);
		m13.addMass(new AdvancedSet<String>("l", "h"), 0.05);
		m13.addMass(new AdvancedSet<String>("n", "h"), 0.3);
		m13.addMass(frame, 0.15);
		
		BBA<String> m14 = new BBA<String>(frame);
		m14.addMass(new AdvancedSet<String>("n"), 0.85);
		m14.addMass(new AdvancedSet<String>("l", "h"), 0.05);
		m14.addMass(new AdvancedSet<String>("n", "h"), 0.05);
		m14.addMass(frame, 0.05);
		
		BBA<String> m15 = new BBA<String>(frame);
		m15.addMass(new AdvancedSet<String>("n"), 0.75);
		m15.addMass(frame, 0.25);
		
		BBA<String> m16 = new BBA<String>(frame);
		m16.addMass(new AdvancedSet<String>("l"), 0.2);
		m16.addMass(new AdvancedSet<String>("n"), 0.8);
		
//		System.out.println(m1 + " <=> " + m1.getPignisticTransformation());
//		System.out.println(m2 + " <=> " + m2.getPignisticTransformation());
//		System.out.println(m3 + " <=> " + m3.getPignisticTransformation());
//		System.out.println(m4 + " <=> " + m4.getPignisticTransformation());
//		System.out.println(m5 + " <=> " + m5.getPignisticTransformation());
//		System.out.println(m6 + " <=> " + m6.getPignisticTransformation());
//		System.out.println(m7 + " <=> " + m7.getPignisticTransformation());
//		System.out.println(m8 + " <=> " + m8.getPignisticTransformation());
//		System.out.println(m9 + " <=> " + m9.getPignisticTransformation());
//		System.out.println(m10 + " <=> " + m10.getPignisticTransformation());
//		System.out.println(m11 + " <=> " + m11.getPignisticTransformation());
//		System.out.println(m12 + " <=> " + m12.getPignisticTransformation());
//		System.out.println(m13 + " <=> " + m13.getPignisticTransformation());
//		System.out.println(m14 + " <=> " + m14.getPignisticTransformation());
//		System.out.println(m15 + " <=> " + m15.getPignisticTransformation());
//		System.out.println(m16 + " <=> " + m16.getPignisticTransformation());
		
//		System.out.println("N(m1)=" + Utilities.format(m1.getNonspecificity()) + ", S(m1)=" + Utilities.format(m1.getStrife()));
//		System.out.println("N(m2)=" + Utilities.format(m2.getNonspecificity()) + ", S(m2)=" + Utilities.format(m2.getStrife()));
//		System.out.println("N(m3)=" + Utilities.format(m3.getNonspecificity()) + ", S(m3)=" + Utilities.format(m3.getStrife()));
//		System.out.println("N(m4)=" + Utilities.format(m4.getNonspecificity()) + ", S(m4)=" + Utilities.format(m4.getStrife()));
//		System.out.println("N(m5)=" + Utilities.format(m5.getNonspecificity()) + ", S(m5)=" + Utilities.format(m5.getStrife()));
//		System.out.println("N(m6)=" + Utilities.format(m6.getNonspecificity()) + ", S(m6)=" + Utilities.format(m6.getStrife()));
//		System.out.println("N(m7)=" + Utilities.format(m7.getNonspecificity()) + ", S(m7)=" + Utilities.format(m7.getStrife()));
//		System.out.println("N(m8)=" + Utilities.format(m8.getNonspecificity()) + ", S(m8)=" + Utilities.format(m8.getStrife()));
//		System.out.println("N(m9)=" + Utilities.format(m9.getNonspecificity()) + ", S(m9)=" + Utilities.format(m9.getStrife()));
//		System.out.println("N(m10)=" + Utilities.format(m10.getNonspecificity()) + ", S(m10)=" + Utilities.format(m10.getStrife()));
//		System.out.println("N(m11)=" + Utilities.format(m11.getNonspecificity()) + ", S(m11)=" + Utilities.format(m11.getStrife()));
//		System.out.println("N(m12)=" + Utilities.format(m12.getNonspecificity()) + ", S(m12)=" + Utilities.format(m12.getStrife()));
//		System.out.println("N(m13)=" + Utilities.format(m13.getNonspecificity()) + ", S(m13)=" + Utilities.format(m13.getStrife()));
//		System.out.println("N(m14)=" + Utilities.format(m14.getNonspecificity()) + ", S(m14)=" + Utilities.format(m14.getStrife()));
//		System.out.println("N(m15)=" + Utilities.format(m15.getNonspecificity()) + ", S(m15)=" + Utilities.format(m15.getStrife()));
//		System.out.println("N(m16)=" + Utilities.format(m16.getNonspecificity()) + ", S(m16)=" + Utilities.format(m16.getStrife()));
		
//		System.out.println("ed(m1,m2)=" + Utilities.format(m1.getEuclideanDistance(m2)));
//        System.out.println("ed(m1,m3)=" + Utilities.format(m1.getEuclideanDistance(m3)));
//        System.out.println("ed(m1,m4)=" + Utilities.format(m1.getEuclideanDistance(m4)));
//        System.out.println("ed(m1,m5)=" + Utilities.format(m1.getEuclideanDistance(m5)));
//        System.out.println("ed(m1,m6)=" + Utilities.format(m1.getEuclideanDistance(m6)));
//        System.out.println("ed(m1,m7)=" + Utilities.format(m1.getEuclideanDistance(m7)));
//        System.out.println("ed(m1,m8)=" + Utilities.format(m1.getEuclideanDistance(m8)));
//        System.out.println("ed(m1,m9)=" + Utilities.format(m1.getEuclideanDistance(m9)));
//        System.out.println("ed(m1,m10)=" + Utilities.format(m1.getEuclideanDistance(m10)));
//        System.out.println("ed(m1,m11)=" + Utilities.format(m1.getEuclideanDistance(m11)));
//        System.out.println("ed(m1,m12)=" + Utilities.format(m1.getEuclideanDistance(m12)));
//        System.out.println("ed(m1,m13)=" + Utilities.format(m1.getEuclideanDistance(m13)));
//        System.out.println("ed(m1,m14)=" + Utilities.format(m1.getEuclideanDistance(m14)));
//        System.out.println("ed(m1,m15)=" + Utilities.format(m1.getEuclideanDistance(m15)));
        
//        System.out.println("jd(m1,m2)=" + Utilities.format(m1.getJousselmeDistance(m2)));
//        System.out.println("jd(m1,m3)=" + Utilities.format(m1.getJousselmeDistance(m3)));
//        System.out.println("jd(m1,m4)=" + Utilities.format(m1.getJousselmeDistance(m4)));
//        System.out.println("jd(m1,m5)=" + Utilities.format(m1.getJousselmeDistance(m5)));
//        System.out.println("jd(m1,m6)=" + Utilities.format(m1.getJousselmeDistance(m6)));
//        System.out.println("jd(m1,m7)=" + Utilities.format(m1.getJousselmeDistance(m7)));
//        System.out.println("jd(m1,m8)=" + Utilities.format(m1.getJousselmeDistance(m8)));
//        System.out.println("jd(m1,m9)=" + Utilities.format(m1.getJousselmeDistance(m9)));
//        System.out.println("jd(m1,m10)=" + Utilities.format(m1.getJousselmeDistance(m10)));
//        System.out.println("jd(m1,m11)=" + Utilities.format(m1.getJousselmeDistance(m11)));
//        System.out.println("jd(m1,m12)=" + Utilities.format(m1.getJousselmeDistance(m12)));
//        System.out.println("jd(m1,m13)=" + Utilities.format(m1.getJousselmeDistance(m13)));
//        System.out.println("jd(m1,m14)=" + Utilities.format(m1.getJousselmeDistance(m14)));
//        System.out.println("jd(m1,m15)=" + Utilities.format(m1.getJousselmeDistance(m15)));
		
//		System.out.println("(m1 && m2)=" + m1.getConjunctiveMerge(m2));
//		System.out.println("(m1 && m3)=" + m1.getConjunctiveMerge(m3));
//		System.out.println("(m1 && m4)=" + m1.getConjunctiveMerge(m4));
//		System.out.println("(m1 && m5)=" + m1.getConjunctiveMerge(m5));
//		System.out.println("(m1 && m6)=" + m1.getConjunctiveMerge(m6));
//		System.out.println("(m1 && m7)=" + m1.getConjunctiveMerge(m7));
//		System.out.println("(m1 && m8)=" + m1.getConjunctiveMerge(m8));
//		System.out.println("(m1 && m9)=" + m1.getConjunctiveMerge(m9));
//		System.out.println("(m1 && m10)=" + m1.getConjunctiveMerge(m10));
//		System.out.println("(m1 && m11)=" + m1.getConjunctiveMerge(m11));
//		System.out.println("(m1 && m12)=" + m1.getConjunctiveMerge(m12));
//		System.out.println("(m1 && m13)=" + m1.getConjunctiveMerge(m13));
//		System.out.println("(m1 && m14)=" + m1.getConjunctiveMerge(m14));
//		System.out.println("(m1 && m15)=" + m1.getConjunctiveMerge(m15));
//		System.out.println("(m1 && m16)=" + m1.getConjunctiveMerge(m16));
		
//		System.out.println("(m1 || m2)=" + m1.getDisjunctiveMerge(m2));
//		System.out.println("(m1 || m3)=" + m1.getDisjunctiveMerge(m3));
//		System.out.println("(m1 || m4)=" + m1.getDisjunctiveMerge(m4));
//		System.out.println("(m1 || m5)=" + m1.getDisjunctiveMerge(m5));
//		System.out.println("(m1 || m6)=" + m1.getDisjunctiveMerge(m6));
//		System.out.println("(m1 || m7)=" + m1.getDisjunctiveMerge(m7));
//		System.out.println("(m1 || m8)=" + m1.getDisjunctiveMerge(m8));
//		System.out.println("(m1 || m9)=" + m1.getDisjunctiveMerge(m9));
//		System.out.println("(m1 || m10)=" + m1.getDisjunctiveMerge(m10));
//		System.out.println("(m1 || m11)=" + m1.getDisjunctiveMerge(m11));
//		System.out.println("(m1 || m12)=" + m1.getDisjunctiveMerge(m12));
//		System.out.println("(m1 || m13)=" + m1.getDisjunctiveMerge(m13));
//		System.out.println("(m1 || m14)=" + m1.getDisjunctiveMerge(m14));
//		System.out.println("(m1 || m15)=" + m1.getDisjunctiveMerge(m15));
//		System.out.println("(m1 || m16)=" + m1.getDisjunctiveMerge(m16));
        
        BBASequence<String> sequence = new BBASequence<String>(frame);
        
//        sequence.add(m1);
//        sequence.add(m2);
//        sequence.add(m3);
//        sequence.add(m4);
//        sequence.add(m5);
//        sequence.add(m6);
//        sequence.add(m7);
//        sequence.add(m8);
//        sequence.add(m9);
//        sequence.add(m10);
//        sequence.add(m11);
//        sequence.add(m12);
//        sequence.add(m13);
//        sequence.add(m14);
//        sequence.add(m15);
//        sequence.add(m16);
//        System.out.println("LPMCS(...)=" + sequence.getLPMCSMerge(0.25, 0.30));
        
		sequence.add(m1);
		sequence.add(m4);
		sequence.add(m8);
		sequence.add(m10);
        sequence.add(m7);
        sequence.add(m9);
        sequence.add(m14);
        sequence.add(m5);
        sequence.add(m6);
        sequence.add(m2);
        sequence.add(m11);
        sequence.add(m12);
        sequence.add(m15);
        sequence.add(m13);
        sequence.add(m3);
        System.out.println("LPMCS(...)=" + sequence.getLPMCSMerge(0.25, 0.30));
	}
	
	public static void main(String[] args) {
		example();
	}
	
}
