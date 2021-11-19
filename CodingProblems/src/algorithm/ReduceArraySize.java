package algorithm;

import java.util.Arrays;

public class ReduceArraySize {

	/*
	{ {1, 2}, 
	  {2, 3}, 
	  {3, 4} }
	*/
	
    public int minSetSize(int[] arr) {
    	int[][] sizePair = new int[arr.length][2];
    	
    	for (int i = 0; i < arr.length; i++) {
    		
    		for (int j = 0; j < sizePair.length; j++) {
    			int[] pair = sizePair[j];
    			
    			if (pair[0] == 0) {
    				pair[0] = arr[i];
    				pair[1]++;
    			}
    			
    			if (pair[0] == arr[i]) {
    				pair[1]++;
    			}
    		}
    		
    	}
    	Arrays.sort(sizePair, (a, b) -> a[1] - b[1]);
    	int minSize = 1;
    	
    	while (true) {
    		int size = 0;
    		
    		for (int i = 0; i < sizePair.length - minSize; i++) {
    			size += sizePair[i][1];
    		}

    		if (size <= arr.length / 2) {
    			break;
    		}
    		minSize++;
    	}
    	
    	return minSize;
    }
}
