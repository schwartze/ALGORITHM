package algorithm;

public class ValidParentheses {
	
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		String s2 = "a)b(c)d";
		String s3 = "))((";
		String s4 = "(a(b(c)d)";
		String res = minRemoveToMakeValid(s4);
		System.out.println(res);
	}

	public static String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder(s);
		boolean isLeft = true;
		
		for (int i = 0, j = sb.length() - 1; i <= j;) {
			
			if (sb.charAt(i) == ')') {
				sb.deleteCharAt(i);
				j--;
				continue;
			}
			
			if (sb.charAt(j) == '(') {
				sb.deleteCharAt(j);
				j--;
				continue;
			}
			
			if (isLeft && sb.charAt(i) == '(') {
				isLeft = false;
				i++;
			} 
			
			if (!isLeft && sb.charAt(j) == ')') {
				isLeft = true;
				j--;
			}
			
			if (!isLeft && sb.charAt(j) != ')') 
				j--;
			
			if (isLeft && sb.charAt(i) != '(') 
				i++;
		}
		
		return sb.toString();
    }
}
