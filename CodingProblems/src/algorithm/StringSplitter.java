package algorithm;

import java.math.BigInteger;

public class StringSplitter {

	public static void main(String[] args) {
		String s = "00110001011111100111101010100010001101001110";
		int res = maxAfterSplit(s);
		System.out.println(res);
	}
	/*
	 * Given a string s of zeros and ones, 
	 * return the maximum score after splitting the string into 
	 * two non-empty substrings (i.e. left substring and right substring).
	 * The score after splitting a string is the number of zeros in the left 
	 * substring plus the number of ones in the right substring.
	 */
    public static int maxScore(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	int max = 0, totalBitCount = Integer.bitCount(Integer.parseInt(s, 2)), len = s.length();
    	
    	while (len-- > 1) {
    		int bCount = Integer.bitCount(Integer.parseInt(sb.toString(), 2) >> 1);
    		int left = len - bCount;
    		int right = totalBitCount - bCount;
    		max = Math.max(max, left + right);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	
    	return max;
    }
    
    public static int maxAfterSplit(String s) {
    	BigInteger strToInt = new BigInteger(s);
		int totalBitCount = strToInt.bitCount();
		int max = 0;
		
    	for (int i = 1; i < s.length(); i++) {
    		String currStr = s.substring(0, i);
        	BigInteger b = new BigInteger(currStr);
    		int currBitCount = b.bitCount();
    		int left = currStr.length() - currBitCount;
    		int right = totalBitCount - currBitCount;
    		max = Math.max(max, left + right);
    	}
    	
    	return max;
    }
}
