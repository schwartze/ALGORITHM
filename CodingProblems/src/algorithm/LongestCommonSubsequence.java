package algorithm;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		String text1 = "abc";
		String text2 = "def";
		
		int res = longestCommonSubsequence(text1, text2);
		System.out.println(res);
	}

    public static int longestCommonSubsequence(String text1, String text2) {
    	String shorter = text1.length() > text2.length() ? text2 : text1;
    	String longer = text1.length() > text2.length() ? text1 : text2;
    	int count = 0, prevIdx = 0;
    	
    	for (char c : shorter.toCharArray()) {
    		int charIdx = longer.indexOf(c);
    		if (charIdx >= 0 && charIdx >= prevIdx) {
    			prevIdx = charIdx;
    			count++;
    		}
    	}
    	
    	return count;
    }
}
