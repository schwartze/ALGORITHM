package algorithm;

import java.util.Stack;

public class ParenthesisArranger {

	public static void main(String[] args) {
		String p = "(()())()";
		String result = solution(p);
		System.out.println(result);
	}
	
    public static String solution(String p) {
        if (p.equals(""))
        	return "";
        
        String[] twoValidStr = divideIntoTwoValidStr(p);
        String u = twoValidStr[0];
        String v = twoValidStr[1];
        
        String vRes = "";
        StringBuilder sb = new StringBuilder();
        if (isValid(u)) {
        	sb.append(u);
        	vRes = solution(v);
        	sb.append(vRes);
        } else {
        	sb.append("(");
        	vRes = solution(v);
        	sb.append(vRes);
        	sb.append(")");
        	
        	String flipped = uOperation(u);
        	sb.append(flipped);
        }
        return sb.toString();
    }
    
    private static String uOperation(String u) {
    	StringBuilder sb = new StringBuilder();
    	String temp = u.substring(1, u.length() - 1);

    	for (char c : temp.toCharArray()) {
    		if (c == ')')
    			sb.append('(');
    		else 
    			sb.append(')');
    	}
    	return sb.toString();
    }
    
    
    private static String[] divideIntoTwoValidStr(String p) {
    	String[] strArr = new String[2];
    	
    	int left = 0;
    	StringBuilder sb = new StringBuilder();
    	for (char c : p.toCharArray()) {
    		sb.append(c);
    		
    		if (c == ')') {
    			left--;
    		} else 
    			left++;
    		if (sb.length() > 0 && left == 0)
    			break;
    	}
    	strArr[0] = sb.toString();
    	strArr[1] = p.substring(strArr[0].length());
    	
    	return strArr;
    }
    
    private static boolean isValid(String p) {
    	Stack<Character> stack = new Stack<>();
    	
    	for (char c : p.toCharArray()) {
    		
    		if (c == '(') {
    			stack.push(c);
    		}
    		
    		if (c == ')') {
    			if (stack.isEmpty())
    				return false;
    			stack.pop();
    		}
    	}
    	return stack.isEmpty();
    }
 }
