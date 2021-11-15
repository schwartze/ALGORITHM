package algorithm;

import java.util.Stack;

public class StackSequence {

	public static void main(String[] args) {
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 3, 5, 1, 2};
		
		int[] pushed2 = {1, 2, 3, 4, 5};
		int[] popped2 = {4, 5, 3, 2, 1};
		
		boolean res = isValidStack(pushed, popped);
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


    
    public static boolean isValidStack(int[] pushed, int[] popped) {
    	Stack<Integer> stack = new Stack<>();
    	int pushedIdx = 0;
    	int poppedIdx = 0;
    	
    	while ( pushedIdx < pushed.length ) {
			stack.push( pushed[ pushedIdx ] );
			
			while ( !stack.isEmpty() && stack.peek() == popped[ poppedIdx ] ) {
				stack.pop();
				poppedIdx++;
			}
			pushedIdx++;
    	}
    	
    	return stack.isEmpty();
    }
}
