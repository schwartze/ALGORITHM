package algorithm;

import java.util.Arrays;

public class ArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
    	int difference = 0;
    	Arrays.sort(arr);
    	
    	for (int i = 1; i < arr.length; i++) {
    		
    		if (i == 1) {
    			difference = arr[i] - arr[i - 1];
    			continue;
    		}
    		
    		if (difference != arr[i] - arr[i - 1])
    			return false;
    	}
    	return true;
    }
}
