package merging_evidence;

public class Pair<T, U> {
	
	private T left;
	private U right;
	
	public Pair(T l, U r) {
		left = l;
		right = r;
	}
	
	public T getLeft() {
		return left;
	}
	
	public U getRight() {
		return right;
	}
	
	@Override
	public String toString() {
		return "(" + left.toString() + ", " + right.toString() + ")";
	}
	
}
