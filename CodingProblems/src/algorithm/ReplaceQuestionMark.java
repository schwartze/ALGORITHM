package algorithm;

public class ReplaceQuestionMark {

	public static void main(String[] args) {
		String s = "j?qg??b";
		String s1 = "b?a";
		String s2 = "??yw?ipkj?";
		String s3 = "ubv?w";
		String s4 = "??";
		String s5 = "a?";
		String s6 = "?";
		
		String res = modifyString(s6);
		System.out.println(res);
	}
	
    public static String modifyString(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	
    	for (int i = 0; i < sb.length(); i++) {
    		if (sb.charAt(i) != 63)
    			continue;
    		sb.replace(i, i + 1, "a");
    		
    		if (sb.length() == 1)
    			break;
    		
    		if (i == 0 || i == sb.length() - 1) {
    			oneOrLast(sb, i);
    			continue;
    		}
    		helper(sb, i);
    	}
    	return sb.toString();
    }
    
    private static void oneOrLast(StringBuilder sb, int idx) {
    	char initialChar = sb.charAt(idx);
    	int num = idx == 0 ? 1 : -1;
    	
    	if (sb.charAt(idx + num) == sb.charAt(idx)) {
    		boolean isConsecutive = true;
    		while(isConsecutive) {
    			if (sb.charAt(idx + num) != sb.charAt(idx)) {
    				isConsecutive = false;
    				break;
    			}
    			sb.setCharAt(idx, ++initialChar);
    		}
    	}
    }
    
    private static void helper(StringBuilder sb, int idx) {
    	char initialChar = sb.charAt(idx);
    	
    	if (sb.charAt(idx + 1) == sb.charAt(idx) || sb.charAt(idx - 1) == sb.charAt(idx)) {
    		boolean isConsecutive = true;
    		while(isConsecutive) {
    			if (sb.charAt(idx + 1) != sb.charAt(idx) && sb.charAt(idx - 1) != sb.charAt(idx)) {
    				isConsecutive = false;
    				break;
    			}
    			sb.setCharAt(idx, ++initialChar);
    		}
    	}
    }
}
