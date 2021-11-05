package algorithm;

import java.util.Stack;

public class ValidParentheses2 {

	public static void main(String[] args) {
		String s = "({[)";
		
		boolean res = isValid(s);
		System.out.println(res);
	}
	
    public static boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	int i = 0;
    	
    	while (i < s.length()) {
    		char curr = s.charAt(i++);
    		
    		if (!stack.isEmpty()) {
    			
    			if (curr == ')' && stack.peek() == '(') {
    				stack.pop();
    				continue;
    			}
    			if (curr == ']' && stack.peek() == '[') {
    				stack.pop();
    				continue;
    			}
    			if (curr == '}' && stack.peek() == '{') {
    				stack.pop();
    				continue;
    			}
    		}
    		stack.push(curr);
    	}
    	return stack.isEmpty();
    }
}
