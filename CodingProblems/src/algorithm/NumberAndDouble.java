package algorithm;

import java.util.HashSet;
import java.util.Set;

public class NumberAndDouble {
	
	public static void main(String[] args) {
		int[] arr = {-20, 8, -6, -14, 0, -19, 14, 4};
		boolean res = checkIfExist2(arr);
		System.out.println(res);
	}

	// using nested for loop
    public static  boolean checkIfExist(int[] arr) {
    	boolean result = false;
  
    	for (int i = 0; i < arr.length; i++) {
    		
    		for (int j = 0; j < arr.length; j++) {
    			
    			if (i == j)
    				continue;
    			
    			if (arr[i] << 1 == arr[j]) {
    				result = true;
    				break;
    			}
    			
    			if (arr[j] << 1 == arr[i]) {
    				result = true;
    				break;
    			}
    		}
    	}
    	return result;
    }
    
    // using hashset
    public static boolean checkIfExist2(int[] arr) {
    	boolean result = false;
    	Set<Integer> set = new HashSet<>();
    	
    	for (int num : arr) {
    		
    		if (set.contains(num * 2) || set.contains(num / 2) || num % 2 == 0) {
    			result = true;
    			break;
    		}
    		set.add(num);
    	}
    	return result;
    }
}
