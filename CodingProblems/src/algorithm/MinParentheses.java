package algorithm;

import java.util.Stack;

public class MinParentheses {

    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
		Stack<Character> stack = new Stack<>();
		
		for (char c : S.toCharArray()) {
			
			if (c == '(') {
				stack.push(c);
				left++;
				continue;
			}
			
			right++;
			if (!stack.isEmpty() && right > 0 && stack.peek() == '(') {
				stack.pop();
				left--;
				right--;
			}
		}
    	return left + right;
    }
}
