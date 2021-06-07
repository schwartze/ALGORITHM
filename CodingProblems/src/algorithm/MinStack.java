package algorithm;

public class MinStack {

	int[] arr;
	int idx = 0;
	int min = Integer.MAX_VALUE;
	
	public MinStack() {
		arr = new int[30000];
    }
    
    public void push(int val) {
    	if (min > val)
    		min = val;
    	
        arr[idx] = val;
        idx++;
    }
    
    public void pop() {
    	if (arr[idx - 1] == min)
    		assignNewMin();
    	
        arr[idx - 1] = 0;
        idx--;
    }
    
    private void assignNewMin() {
    	int newMin = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < idx - 1; i++) {
    		if (arr[i] < newMin)
    			newMin = arr[i];
    	}
    	
    	min = newMin;
    }
    
    public int top() {
    	return arr[idx - 1];
    }
    
    public int getMin() {
        return min;
    }
}
