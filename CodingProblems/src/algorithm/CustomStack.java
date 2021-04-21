package algorithm;

public class CustomStack {

	int[] stackArr;
	int curr = 0;
	
    public CustomStack(int maxSize) {
    	stackArr = new int[maxSize];
    }
    
    public void push(int x) {
    	if (stackArr[stackArr.length - 1] > 0)
    		return;
    	
    	stackArr[curr++] = x;
    }
    
    public int pop() {
    	if (curr == 0)
    		return -1;
    	
    	curr--;
    	int originalVal = stackArr[curr];
    	stackArr[curr] = 0;
    	
    	return originalVal;
    }
    
    public void increment(int k, int val) {
    	if (curr < k) 
    		k = curr;
    	
    	for (int i = 0; i < k && i < stackArr.length; i++) {
    		stackArr[i] += val;
    	}
    }
}
