package algorithm;

import java.util.Stack;

public class StackSequence {

	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 3, 5, 1, 2};
		
		int[] pushed2 = {1, 2, 3, 4, 5};
		int[] popped2 = {4, 5, 3, 2, 1};
		
		boolean res = validateStackSequences(pushed2, popped2);
		System.out.println(res);
	}
	
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
    	Stack<Integer> stack = new Stack<>();
    	int i = 0; 
    	
    	for (int n : pushed) {
    		stack.push(n);
    		
    		while (!stack.isEmpty() && stack.peek() == popped[i]) {
    			stack.pop();
    			i++;
    		}
    	}
    	
    	return stack.empty();
    }
}
