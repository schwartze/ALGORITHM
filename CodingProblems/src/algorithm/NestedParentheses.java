package algorithm;

public class NestedParentheses {
	
	public static void main(String[] args) {
		String s = "(1+(2*3)+((8)/4))+1";
		String s2 = "(1)+((2))+(((3)))";
		String s3 = "1+(2*3)/(2-1)";
		String s4 = "1";

		int res = maxDepth(s3);
		System.out.println(res);
	}
	
    public static int maxDepth(String s) {
    	int depth = 0, left = 0;
    	
    	for (char c : s.toCharArray()) {
    		if (c == 40) {
    			left++;
    		} else if (c == 41 && left > 0) {
        		depth = Math.max(left, depth);
    			left--;
    		}
    	}
    	return depth;
    }
}
