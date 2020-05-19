package algorithm;

public class RepeatedString {
	
	public static void main(String[] args) {
		RepeatedString repeatedStr = new RepeatedString();
		int n = repeatedStr.repeatedTimes("abc", "cabcabca");
		System.out.println(n);
	}
	// find out how many times A should be repeated for B to be a substring of repeated A
	public int repeatedTimes(String A, String B) {
		
		int count = 1;
		
		StringBuilder sb = new StringBuilder(A);
		
		for (; sb.length() < B.length(); count++) {
			sb.append(A);
		}
		
		if (sb.indexOf(B) >= 0)
			return count;
		
		if (sb.append(A).indexOf(B) >= 0)
			return count + 1;
		
		return -1;
	}
}
