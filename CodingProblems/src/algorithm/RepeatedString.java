package algorithm;

public class RepeatedString {
	
	public static void main(String[] args) {
		RepeatedString repeatedStr = new RepeatedString();
		int n = repeatedStr.repeatedTimes("abcd", "cdabcdab");
		System.out.println(n);
	}
	// find out how many times A should be repeated for B to be a substring of repeated A
	public int repeatedTimes(String A, String B) {
		
		String[] arr = B.replaceAll(A, "-").split("-");
		int count = 0;
		
		for (String str : arr) {
			
			if (A.indexOf(str) == -1)
				return -1;
			count++;
		}
		
		return count + arr.length - 1;
	}

}
