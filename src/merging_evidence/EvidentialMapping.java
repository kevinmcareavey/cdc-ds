package merging_evidence;

public abstract class EvidentialMapping<T, U> {
	
	private AdvancedSet<T> evidenceFrame;
	private AdvancedSet<U> hypothesesFrame;
	
	public EvidentialMapping(AdvancedSet<T> e, AdvancedSet<U> h) {
		evidenceFrame = e;
		hypothesesFrame = h;
	}
	
	public AdvancedSet<T> getEvidenceFrame() {
		return evidenceFrame;
	}
	
	public AdvancedSet<U> getHypothesesFrame() {
		return hypothesesFrame;
	}
	
}
