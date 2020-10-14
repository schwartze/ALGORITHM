package algorithm;

public class GreatestOnTheRight {

	public static void main(String[] args) {
		int[] arr = {17, 18, 5, 4, 6, 1};
		int[] res = replaceToRightMax(arr);
		
		for (int n : res)
			System.out.println(n + ", ");
	}
	// Replace each element of the given array for it to have 
	// the largest number on right side 
    public static int[] replaceElements(int[] arr) {
    	int[] res = new int[arr.length];
    	
    	for (int i = 0; i < arr.length; i++) {
    		int maxInRight = 0;
    		
    		for (int j = i + 1; j < arr.length; j++) {
    			maxInRight = Math.max(arr[j], maxInRight);
    		}	
    		res[i] = maxInRight;
    	}
    	res[arr.length - 1] = -1;
    	return res;
    }
    
    public static int[] replaceToRightMax(int[] arr) {
    	int max = -1;
    	
    	for (int i = arr.length - 1; i >= 0; i--) {
    		int temp = arr[i];
    		arr[i] = max;
    		max = Math.max(temp, arr[i]);
    	}
    	return arr;
    }
}
