package algorithm;

import java.util.Arrays;

public class ReverseSubarray {

	public static void main(String[] args) {
		int[] target = {3, 7, 9};
		int[] arr = {3, 7, 11};
		
		boolean res = isEqual(target, arr);
		System.out.println(res);
	}
	
    public static boolean canBeEqual(int[] target, int[] arr) {
    	
    	int[] freq = new int[1001];
    	
    	for (int i = 0; i < target.length; i++) {
    		freq[target[i]]++;
    		freq[arr[i]]--;
    	}
    	
    	for (int n : target)
    		if (freq[n] != 0)
    			return false;
    	
    	return true;
    }
    
    public static boolean isEqual(int[] target, int[] arr) {
    	Arrays.sort(arr);
    	Arrays.sort(target);
    	
    	return Arrays.equals(target, arr);
    }
}
