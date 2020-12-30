package algorithm;

public class LargestSubstring {

	public static void main(String[] args) {
		String s = "aa";
		String s2 = "abca";
		String s3 = "cbzxy";
		String s4 = "cabbac";
		String s5 = "mgntdygtxrvxjnwksqhxuxtrv";
				
		
		int res = maxLengthBetweenEqualCharacters(s4);
		System.out.println(res);
	}
	
    public static int maxLengthBetweenEqualCharacters(String s) {
		int max = -1;
    	
    	for (int i = 0; i < s.length(); i++) {
    		int lastIdx = s.lastIndexOf(s.charAt(i) + "");
    		
    		if (i == lastIdx)
    			continue;
			max = Math.max(max, lastIdx - i - 1);
    	}
    	return max;
    }
}
