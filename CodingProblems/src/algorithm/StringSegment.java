package algorithm;

public class StringSegment {

	// return number of segments in the given string
	// e.g.) "Hello, this is Sumi" has four segments
	public int countSegments(String str) {
		
		String trimmedStr = str.trim();
		
		return trimmedStr.split(" ").length;
	}
}
