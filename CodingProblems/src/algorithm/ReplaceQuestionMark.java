package algorithm;

public class ReplaceQuestionMark {

	public static void main(String[] args) {
		String s = "j?qg??b";
		String s1 = "b?a";
		String s2 = "??yw?ipkj?";
		String s3 = "ubv?w";
		String s4 = "??";
		
		String res = modifyString(s);
		System.out.println(res);
	}
	
    public static String modifyString(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	char tempChar = 'a';
    	
    	for (int i = 0; i < sb.length(); i++) {
    		if (sb.charAt(i) != 63)
    			continue;
    		sb.replace(i, i + 1, Character.toString(tempChar));
    		tempChar++;
    		helper2(sb, i);
    	}
    	return sb.toString();
    }
    
    private static void helper(StringBuilder sb, int idx, int num) {
    	char initialChar = sb.charAt(idx);
    	
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
    
    private static void helper2(StringBuilder sb, int idx) {
    	char initialChar = sb.charAt(idx);
    	int n1 = 1, n2 = -1;
    	boolean notOneOrLast = true;
    	
    	if (idx == 0) {
    		n2 = 0;
    		notOneOrLast = false;
    	}

    	if (idx == sb.length() - 1) {
    		n1 = 0;
    		notOneOrLast = false;
    	}
    	
    	if ((sb.charAt(idx + n1) == sb.charAt(idx) || sb.charAt(idx + n2) == sb.charAt(idx)) && notOneOrLast) {
    		boolean isConsecutive = true;
    		while(isConsecutive) {
    			if (sb.charAt(idx + n1) != sb.charAt(idx) && sb.charAt(idx + n2) != sb.charAt(idx)) {
    				isConsecutive = false;
    				break;
    			}
    			sb.setCharAt(idx, ++initialChar);
    		}
    	}
    }
}
