package paper;

import java.util.ArrayList;

import merging_evidence.AdvancedSet;
import merging_evidence.BBA;
import merging_evidence.EvidentialMapping;

public class Section4 {
	
	private AdvancedSet<String> evidenceFrame;
	private AdvancedSet<String> hypothesesFrame;
	
	private EvidentialMapping<String, String> basicEvidentialMapping;
	
	public Section4() {
		evidenceFrame = new AdvancedSet<String>("e1", "e2", "e3");
		hypothesesFrame = new AdvancedSet<String>("h1", "h2", "h3", "h4");
		
		basicEvidentialMapping = new EvidentialMapping<String, String>(evidenceFrame, hypothesesFrame);
		basicEvidentialMapping.addMass("e1", new AdvancedSet<String>("h1", "h2"), 0.5);
		basicEvidentialMapping.addMass("e1", new AdvancedSet<String>("h3"), 0.5);
		basicEvidentialMapping.addMass("e2", new AdvancedSet<String>("h1", "h2"), 0.7);
		basicEvidentialMapping.addMass("e2", new AdvancedSet<String>("h4"), 0.3);
		basicEvidentialMapping.addMass("e3", new AdvancedSet<String>("h4"), 1);
	}
	
	public void table4a() {
		System.out.println(basicEvidentialMapping);
	}
	
	public void table4b() throws Exception {
		ArrayList<AdvancedSet<String>> eSets = new ArrayList<AdvancedSet<String>>();
		eSets.add(new AdvancedSet<String>("e1"));
		eSets.add(new AdvancedSet<String>("e2"));
		eSets.add(new AdvancedSet<String>("e3"));
		eSets.add(new AdvancedSet<String>("e1", "e2"));
		eSets.add(new AdvancedSet<String>("e1", "e3"));
		eSets.add(new AdvancedSet<String>("e2", "e3"));
		eSets.add(evidenceFrame);
		
		ArrayList<AdvancedSet<String>> hSets = new ArrayList<AdvancedSet<String>>();
		hSets.add(new AdvancedSet<String>("h1", "h2"));
		hSets.add(new AdvancedSet<String>("h3"));
		hSets.add(new AdvancedSet<String>("h4"));
		hSets.add(new AdvancedSet<String>("h1", "h2", "h4"));
		hSets.add(hypothesesFrame);
		
		for(AdvancedSet<String> eSet : eSets) {
			String delim = "";
			for(AdvancedSet<String> hSet : hSets) {
				System.out.print(delim + "\\Gamma*(" + eSet + ", " + hSet + ")=" + basicEvidentialMapping.getCompleteMass(eSet, hSet));
				delim = ", ";
			}
			System.out.println();
		}
	}
	
	public void example6() {
		BBA<String> me = new BBA<String>("m_e", evidenceFrame);
		me.setMass(new AdvancedSet<String>("e2"), 0.7);
		me.setMass(evidenceFrame, 0.3);
		System.out.println(basicEvidentialMapping.getEvidencePropagation(me));
	}
	
	public static void main(String[] args) {
		try {
			Section4 section4 = new Section4();
			section4.table4a();
			section4.table4b();
			section4.example6();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
