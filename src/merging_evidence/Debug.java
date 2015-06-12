package merging_evidence;

public class Debug {

	public static void test() {
		try {
			AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");

			BBA<String> m1 = new BBA<String>("m1", frame);
			m1.addMass(new AdvancedSet<String>("l"), 0.05);
			m1.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m2 = new BBA<String>("m2", frame);
			m2.addMass(new AdvancedSet<String>("l"), 0.22);
			m2.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m3 = new BBA<String>("m3", frame);
			m3.addMass(new AdvancedSet<String>("l"), 0.56);
			m3.addMass(new AdvancedSet<String>("n"), 0.44);

			BBA<String> m4 = new BBA<String>("m4", frame);
			m4.addMass(new AdvancedSet<String>("l"), 0.05);
			m4.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m5 = new BBA<String>("m5", frame);
			m5.addMass(new AdvancedSet<String>("n"), 0.85);
			m5.addMass(new AdvancedSet<String>("h"), 0.15);

			BBA<String> m6 = new BBA<String>("m6", frame);
			m6.addMass(new AdvancedSet<String>("n"), 0.85);
			m6.addMass(new AdvancedSet<String>("h"), 0.15);

			BBA<String> m7 = new BBA<String>("m7", frame);
			m7.addMass(new AdvancedSet<String>("l"), 0.15);
			m7.addMass(new AdvancedSet<String>("n"), 0.85);

			BBA<String> m8 = new BBA<String>("m8", frame);
			m8.addMass(new AdvancedSet<String>("l"), 0.05);
			m8.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m9 = new BBA<String>("m9", frame);
			m9.addMass(new AdvancedSet<String>("l"), 0.15);
			m9.addMass(new AdvancedSet<String>("n"), 0.85);

			BBA<String> m10 = new BBA<String>("m10", frame);
			m10.addMass(new AdvancedSet<String>("l"), 0.1);
			m10.addMass(new AdvancedSet<String>("n"), 0.9);

			BBA<String> m11 = new BBA<String>("m11", frame);
			m11.addMass(new AdvancedSet<String>("l"), 0.22);
			m11.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m12 = new BBA<String>("m12", frame);
			m12.addMass(new AdvancedSet<String>("l"), 0.22);
			m12.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m13 = new BBA<String>("m13", frame);
			m13.addMass(new AdvancedSet<String>("n"), 0.5);
			m13.addMass(new AdvancedSet<String>("l", "h"), 0.05);
			m13.addMass(new AdvancedSet<String>("n", "h"), 0.3);
			m13.addMass(frame, 0.15);

			BBA<String> m14 = new BBA<String>("m14", frame);
			m14.addMass(new AdvancedSet<String>("n"), 0.85);
			m14.addMass(new AdvancedSet<String>("l", "h"), 0.05);
			m14.addMass(new AdvancedSet<String>("n", "h"), 0.05);
			m14.addMass(frame, 0.05);

			BBA<String> m15 = new BBA<String>("m15", frame);
			m15.addMass(new AdvancedSet<String>("n"), 0.75);
			m15.addMass(frame, 0.25);

			BBA<String> m16 = new BBA<String>("m16", frame);
			m16.addMass(new AdvancedSet<String>("l"), 0.2);
			m16.addMass(new AdvancedSet<String>("n"), 0.8);

			System.out.println(m1 + " <=> " + m1.getPignisticTransformation());
			System.out.println(m2 + " <=> " + m2.getPignisticTransformation());
			System.out.println(m3 + " <=> " + m3.getPignisticTransformation());
			System.out.println(m4 + " <=> " + m4.getPignisticTransformation());
			System.out.println(m5 + " <=> " + m5.getPignisticTransformation());
			System.out.println(m6 + " <=> " + m6.getPignisticTransformation());
			System.out.println(m7 + " <=> " + m7.getPignisticTransformation());
			System.out.println(m8 + " <=> " + m8.getPignisticTransformation());
			System.out.println(m9 + " <=> " + m9.getPignisticTransformation());
			System.out.println(m10 + " <=> " + m10.getPignisticTransformation());
			System.out.println(m11 + " <=> " + m11.getPignisticTransformation());
			System.out.println(m12 + " <=> " + m12.getPignisticTransformation());
			System.out.println(m13 + " <=> " + m13.getPignisticTransformation());
			System.out.println(m14 + " <=> " + m14.getPignisticTransformation());
			System.out.println(m15 + " <=> " + m15.getPignisticTransformation());
			System.out.println(m16 + " <=> " + m16.getPignisticTransformation());

			System.out.println("N(m1)=" + Utilities.format(m1.getNonspecificity()) + ", S(m1)=" + Utilities.format(m1.getStrife()));
			System.out.println("N(m2)=" + Utilities.format(m2.getNonspecificity()) + ", S(m2)=" + Utilities.format(m2.getStrife()));
			System.out.println("N(m3)=" + Utilities.format(m3.getNonspecificity()) + ", S(m3)=" + Utilities.format(m3.getStrife()));
			System.out.println("N(m4)=" + Utilities.format(m4.getNonspecificity()) + ", S(m4)=" + Utilities.format(m4.getStrife()));
			System.out.println("N(m5)=" + Utilities.format(m5.getNonspecificity()) + ", S(m5)=" + Utilities.format(m5.getStrife()));
			System.out.println("N(m6)=" + Utilities.format(m6.getNonspecificity()) + ", S(m6)=" + Utilities.format(m6.getStrife()));
			System.out.println("N(m7)=" + Utilities.format(m7.getNonspecificity()) + ", S(m7)=" + Utilities.format(m7.getStrife()));
			System.out.println("N(m8)=" + Utilities.format(m8.getNonspecificity()) + ", S(m8)=" + Utilities.format(m8.getStrife()));
			System.out.println("N(m9)=" + Utilities.format(m9.getNonspecificity()) + ", S(m9)=" + Utilities.format(m9.getStrife()));
			System.out.println("N(m10)=" + Utilities.format(m10.getNonspecificity()) + ", S(m10)=" + Utilities.format(m10.getStrife()));
			System.out.println("N(m11)=" + Utilities.format(m11.getNonspecificity()) + ", S(m11)=" + Utilities.format(m11.getStrife()));
			System.out.println("N(m12)=" + Utilities.format(m12.getNonspecificity()) + ", S(m12)=" + Utilities.format(m12.getStrife()));
			System.out.println("N(m13)=" + Utilities.format(m13.getNonspecificity()) + ", S(m13)=" + Utilities.format(m13.getStrife()));
			System.out.println("N(m14)=" + Utilities.format(m14.getNonspecificity()) + ", S(m14)=" + Utilities.format(m14.getStrife()));
			System.out.println("N(m15)=" + Utilities.format(m15.getNonspecificity()) + ", S(m15)=" + Utilities.format(m15.getStrife()));
			System.out.println("N(m16)=" + Utilities.format(m16.getNonspecificity()) + ", S(m16)=" + Utilities.format(m16.getStrife()));

			System.out.println("ed(m1,m2)=" + Utilities.format(m1.getEuclideanDistance(m2)));
			System.out.println("ed(m1,m3)=" + Utilities.format(m1.getEuclideanDistance(m3)));
			System.out.println("ed(m1,m4)=" + Utilities.format(m1.getEuclideanDistance(m4)));
			System.out.println("ed(m1,m5)=" + Utilities.format(m1.getEuclideanDistance(m5)));
			System.out.println("ed(m1,m6)=" + Utilities.format(m1.getEuclideanDistance(m6)));
			System.out.println("ed(m1,m7)=" + Utilities.format(m1.getEuclideanDistance(m7)));
			System.out.println("ed(m1,m8)=" + Utilities.format(m1.getEuclideanDistance(m8)));
			System.out.println("ed(m1,m9)=" + Utilities.format(m1.getEuclideanDistance(m9)));
			System.out.println("ed(m1,m10)=" + Utilities.format(m1.getEuclideanDistance(m10)));
			System.out.println("ed(m1,m11)=" + Utilities.format(m1.getEuclideanDistance(m11)));
			System.out.println("ed(m1,m12)=" + Utilities.format(m1.getEuclideanDistance(m12)));
			System.out.println("ed(m1,m13)=" + Utilities.format(m1.getEuclideanDistance(m13)));
			System.out.println("ed(m1,m14)=" + Utilities.format(m1.getEuclideanDistance(m14)));
			System.out.println("ed(m1,m15)=" + Utilities.format(m1.getEuclideanDistance(m15)));

			System.out.println("jd(m1,m2)=" + Utilities.format(m1.getJousselmeDistance(m2)));
			System.out.println("jd(m1,m3)=" + Utilities.format(m1.getJousselmeDistance(m3)));
			System.out.println("jd(m1,m4)=" + Utilities.format(m1.getJousselmeDistance(m4)));
			System.out.println("jd(m1,m5)=" + Utilities.format(m1.getJousselmeDistance(m5)));
			System.out.println("jd(m1,m6)=" + Utilities.format(m1.getJousselmeDistance(m6)));
			System.out.println("jd(m1,m7)=" + Utilities.format(m1.getJousselmeDistance(m7)));
			System.out.println("jd(m1,m8)=" + Utilities.format(m1.getJousselmeDistance(m8)));
			System.out.println("jd(m1,m9)=" + Utilities.format(m1.getJousselmeDistance(m9)));
			System.out.println("jd(m1,m10)=" + Utilities.format(m1.getJousselmeDistance(m10)));
			System.out.println("jd(m1,m11)=" + Utilities.format(m1.getJousselmeDistance(m11)));
			System.out.println("jd(m1,m12)=" + Utilities.format(m1.getJousselmeDistance(m12)));
			System.out.println("jd(m1,m13)=" + Utilities.format(m1.getJousselmeDistance(m13)));
			System.out.println("jd(m1,m14)=" + Utilities.format(m1.getJousselmeDistance(m14)));
			System.out.println("jd(m1,m15)=" + Utilities.format(m1.getJousselmeDistance(m15)));

			System.out.println("(m1 && m2)=" + m1.getConjunctiveMerge(m2));
			System.out.println("(m1 && m3)=" + m1.getConjunctiveMerge(m3));
			System.out.println("(m1 && m4)=" + m1.getConjunctiveMerge(m4));
			System.out.println("(m1 && m5)=" + m1.getConjunctiveMerge(m5));
			System.out.println("(m1 && m6)=" + m1.getConjunctiveMerge(m6));
			System.out.println("(m1 && m7)=" + m1.getConjunctiveMerge(m7));
			System.out.println("(m1 && m8)=" + m1.getConjunctiveMerge(m8));
			System.out.println("(m1 && m9)=" + m1.getConjunctiveMerge(m9));
			System.out.println("(m1 && m10)=" + m1.getConjunctiveMerge(m10));
			System.out.println("(m1 && m11)=" + m1.getConjunctiveMerge(m11));
			System.out.println("(m1 && m12)=" + m1.getConjunctiveMerge(m12));
			System.out.println("(m1 && m13)=" + m1.getConjunctiveMerge(m13));
			System.out.println("(m1 && m14)=" + m1.getConjunctiveMerge(m14));
			System.out.println("(m1 && m15)=" + m1.getConjunctiveMerge(m15));
			System.out.println("(m1 && m16)=" + m1.getConjunctiveMerge(m16));

			System.out.println("(m1 || m2)=" + m1.getDisjunctiveMerge(m2));
			System.out.println("(m1 || m3)=" + m1.getDisjunctiveMerge(m3));
			System.out.println("(m1 || m4)=" + m1.getDisjunctiveMerge(m4));
			System.out.println("(m1 || m5)=" + m1.getDisjunctiveMerge(m5));
			System.out.println("(m1 || m6)=" + m1.getDisjunctiveMerge(m6));
			System.out.println("(m1 || m7)=" + m1.getDisjunctiveMerge(m7));
			System.out.println("(m1 || m8)=" + m1.getDisjunctiveMerge(m8));
			System.out.println("(m1 || m9)=" + m1.getDisjunctiveMerge(m9));
			System.out.println("(m1 || m10)=" + m1.getDisjunctiveMerge(m10));
			System.out.println("(m1 || m11)=" + m1.getDisjunctiveMerge(m11));
			System.out.println("(m1 || m12)=" + m1.getDisjunctiveMerge(m12));
			System.out.println("(m1 || m13)=" + m1.getDisjunctiveMerge(m13));
			System.out.println("(m1 || m14)=" + m1.getDisjunctiveMerge(m14));
			System.out.println("(m1 || m15)=" + m1.getDisjunctiveMerge(m15));
			System.out.println("(m1 || m16)=" + m1.getDisjunctiveMerge(m16));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void cima() {
		try {
			AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");

			BBA<String> m1 = new BBA<String>("m1", frame);
			m1.addMass(new AdvancedSet<String>("l"), 0.05);
			m1.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m2 = new BBA<String>("m2", frame);
			m2.addMass(new AdvancedSet<String>("l"), 0.22);
			m2.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m3 = new BBA<String>("m3", frame);
			m3.addMass(new AdvancedSet<String>("l"), 0.56);
			m3.addMass(new AdvancedSet<String>("n"), 0.44);

			BBA<String> m4 = new BBA<String>("m4", frame);
			m4.addMass(new AdvancedSet<String>("l"), 0.05);
			m4.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m5 = new BBA<String>("m5", frame);
			m5.addMass(new AdvancedSet<String>("n"), 0.85);
			m5.addMass(new AdvancedSet<String>("h"), 0.15);

			BBA<String> m6 = new BBA<String>("m6", frame);
			m6.addMass(new AdvancedSet<String>("n"), 0.85);
			m6.addMass(new AdvancedSet<String>("h"), 0.15);

			BBA<String> m7 = new BBA<String>("m7", frame);
			m7.addMass(new AdvancedSet<String>("l"), 0.15);
			m7.addMass(new AdvancedSet<String>("n"), 0.85);

			BBA<String> m8 = new BBA<String>("m8", frame);
			m8.addMass(new AdvancedSet<String>("l"), 0.05);
			m8.addMass(new AdvancedSet<String>("n"), 0.95);

			BBA<String> m9 = new BBA<String>("m9", frame);
			m9.addMass(new AdvancedSet<String>("l"), 0.15);
			m9.addMass(new AdvancedSet<String>("n"), 0.85);

			BBA<String> m10 = new BBA<String>("m10", frame);
			m10.addMass(new AdvancedSet<String>("l"), 0.1);
			m10.addMass(new AdvancedSet<String>("n"), 0.9);

			BBA<String> m11 = new BBA<String>("m11", frame);
			m11.addMass(new AdvancedSet<String>("l"), 0.22);
			m11.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m12 = new BBA<String>("m12", frame);
			m12.addMass(new AdvancedSet<String>("l"), 0.22);
			m12.addMass(new AdvancedSet<String>("n"), 0.78);

			BBA<String> m13 = new BBA<String>("m13", frame);
			m13.addMass(new AdvancedSet<String>("n"), 0.5);
			m13.addMass(new AdvancedSet<String>("l", "h"), 0.05);
			m13.addMass(new AdvancedSet<String>("n", "h"), 0.3);
			m13.addMass(frame, 0.15);

			BBA<String> m14 = new BBA<String>("m14", frame);
			m14.addMass(new AdvancedSet<String>("n"), 0.85);
			m14.addMass(new AdvancedSet<String>("l", "h"), 0.05);
			m14.addMass(new AdvancedSet<String>("n", "h"), 0.05);
			m14.addMass(frame, 0.05);

			BBA<String> m15 = new BBA<String>("m15", frame);
			m15.addMass(new AdvancedSet<String>("n"), 0.75);
			m15.addMass(frame, 0.25);

			BBA<String> m16 = new BBA<String>("m16", frame);
			m16.addMass(new AdvancedSet<String>("l"), 0.2);
			m16.addMass(new AdvancedSet<String>("n"), 0.8);

			BBASet<String> set = new BBASet<String>(frame);
			set.add(m1);
			set.add(m2);
			set.add(m3);
			set.add(m4);
			set.add(m5);
			set.add(m6);
			set.add(m7);
			set.add(m8);
			set.add(m9);
			set.add(m10);
			set.add(m11);
			set.add(m12);
			set.add(m13);
			set.add(m14);
			set.add(m15);

			System.out.println("LPMCS := " + set.getLPMCSMerge(0.25, 0.30).getLabel());
			System.out.println("Conjunctive := " + set.getConjunctiveMerge().getLabel());
			System.out.println("Disjunctive := " + set.getDisjunctiveMerge().getLabel());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void lpmces2_3_1() {

		try {
			AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");

			BBA<String> m1 = new BBA<String>("m1", frame);
			m1.addMass(new AdvancedSet<String>("l"), 0.80);
			m1.addMass(new AdvancedSet<String>("h"), 0.15);
			m1.addMass(new AdvancedSet<String>("n","h"), 0.05);

			BBA<String> m2 = new BBA<String>("m2", frame);
			m2.addMass(new AdvancedSet<String>("l"), 0.60);
			m2.addMass(new AdvancedSet<String>("h"), 0.10);	
			m2.addMass(new AdvancedSet<String>("l","h"), 0.30);

			BBA<String> m3 = new BBA<String>("m3", frame);
			m3.addMass(new AdvancedSet<String>("n"), 0.80);
			m3.addMass(new AdvancedSet<String>("h"), 0.14);
			m3.addMass(new AdvancedSet<String>("l","h"), 0.06);

			BBA<String> m4 = new BBA<String>("m4", frame);
			m4.addMass(new AdvancedSet<String>("n"), 0.83);
			m4.addMass(new AdvancedSet<String>("n","h"), 0.16);
			m4.addMass(frame, 0.01);

			BBA<String> m5 = new BBA<String>("m5", frame);
			m5.addMass(new AdvancedSet<String>("n"), 0.70);
			m5.addMass(new AdvancedSet<String>("l","h"), 0.30);

			BBA<String> m6 = new BBA<String>("m6", frame);
			m6.addMass(new AdvancedSet<String>("n"), 0.25);
			m6.addMass(new AdvancedSet<String>("h"), 0.57);
			m6.addMass(new AdvancedSet<String>("l","n"), 0.18);

			BBASet<String> set = new BBASet<String>(frame);
			set.add(m1);
			set.add(m2);
			set.add(m3);
			set.add(m4);
			set.add(m5);
			set.add(m6);

//			BBA<String> merged = set.getConjunctiveMerge();
//			BBA<String> merged = set.getDisjunctiveMerge();
			BBA<String> merged = set.getLPMCSMerge(0.50, 0.35);
			System.out.println("sequence  := " + merged.getLabel());
			System.out.println("BBA       := " + merged);
			System.out.println("pignistic := " + merged.getPignisticTransformation());
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void reference() {
		try {
			AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");

			BBA<String> m1 = new BBA<String>("m1", frame);
			m1.addMass(new AdvancedSet<String>("l"), 0.80);
			m1.addMass(new AdvancedSet<String>("h"), 0.20);
			
			BBA<String> m2 = new BBA<String>("m2", frame);
			m2.addMass(new AdvancedSet<String>("l"), 0.80);
			m2.addMass(new AdvancedSet<String>("n"), 0.20);
			
			BBA<String> m3 = new BBA<String>("m3", frame);
			m3.addMass(new AdvancedSet<String>("l"), 0.79);
			m3.addMass(new AdvancedSet<String>("h"), 0.21);
			
			BBASet<String> set = new BBASet<String>(frame);
			set.add(m1);
			set.add(m2);
			set.add(m3);
			
			for(BBA<String> other : set) {
				System.out.println(other.getLabel() + "=" + other);
			}
			System.out.println();
			
			for(BBA<String> other : set) {
				System.out.println("N(" + other.getLabel() + ")=" + Utilities.format(other.getNonspecificity()) + ", S(" + other.getLabel() + ")=" + Utilities.format(other.getStrife()));
			}
			System.out.println();
			
			BBA<String> left;
			BBA<String> right;
			BBA<String> merge;
			
			left = m1;
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m2;
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m1;
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			left = m2;
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m3);
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m3);
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			merge = m1.getConjunctiveMerge(m3).getConjunctiveMerge(m2);
			System.out.println(merge.getLabel() + " := " + merge);
			merge = m2.getDisjunctiveMerge(m1.getConjunctiveMerge(m3));
			System.out.println(merge.getLabel() + " := " + merge);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void distance() {
		try {
			AdvancedSet<String> frame = new AdvancedSet<String>("l", "n", "h");

			BBA<String> m1 = new BBA<String>("m1", frame);
			m1.addMass(new AdvancedSet<String>("l"), 0.70);
			m1.addMass(new AdvancedSet<String>("n"), 0.20);
			m1.addMass(new AdvancedSet<String>("h"), 0.10);
			
			BBA<String> m2 = new BBA<String>("m2", frame);
			m2.addMass(new AdvancedSet<String>("l"), 0.68);
			m2.addMass(new AdvancedSet<String>("n"), 0.22);
			m2.addMass(new AdvancedSet<String>("h"), 0.10);
			
			BBA<String> m3 = new BBA<String>("m3", frame);
			m3.addMass(new AdvancedSet<String>("l"), 0.68);
			m3.addMass(new AdvancedSet<String>("n"), 0.20);
			m3.addMass(new AdvancedSet<String>("h"), 0.12);
			
			BBASet<String> set = new BBASet<String>(frame);
			set.add(m1);
			set.add(m2);
			set.add(m3);
			
			for(BBA<String> other : set) {
				System.out.println(other.getLabel() + "=" + other);
			}
			System.out.println();
			
			for(BBA<String> other : set) {
				System.out.println("N(" + other.getLabel() + ")=" + Utilities.format(other.getNonspecificity()) + ", S(" + other.getLabel() + ")=" + Utilities.format(other.getStrife()));
			}
			System.out.println();
			
			BBA<String> left;
			BBA<String> right;
			BBA<String> merge;
			
			left = m1;
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m1;
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m2);
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m2);
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m3);
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m1.getConjunctiveMerge(m3);
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			left = m2;
			System.out.println("d(" + left.getLabel() + "," + m1.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m1)));
			System.out.println("d(" + left.getLabel() + "," + m2.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m2)));
			System.out.println("d(" + left.getLabel() + "," + m3.getLabel() + ")=" + Utilities.format(left.getJousselmeDistance(m3)));
			System.out.println();
			
			left = m2;
			right = m1;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m2;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			right = m3;
			merge = left.getConjunctiveMerge(right);
			System.out.println("K(" + left.getLabel() + "," + right.getLabel() + ")=" + Utilities.format(left.getConflict(right)) + ", " + "S(" + merge.getLabel() + ")=" + Utilities.format(merge.getStrife()));
			System.out.println();
			
			merge = m1.getConjunctiveMerge(m2).getConjunctiveMerge(m3);
			System.out.println(merge.getLabel() + " := " + merge);
			merge = m1.getDisjunctiveMerge(m2).getDisjunctiveMerge(m3);
			System.out.println(merge.getLabel() + " := " + merge);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		test();
//		cima();
//		lpmces2_3_1();
//		reference();
		distance();
	}

}
