package algorithm;

import java.util.Arrays;

public class MinCostTree {

    public int mctFromLeafValues(int[] arr) {
    	Arrays.sort(arr);
    	int minCost = 0;
    	int[] temp = arr;
    	
    	while (temp.length > 1) {
    		int[] multipleArr = new int[temp.length / 2];
    		
    		for (int i = 0, j = 0; i < temp.length; i+=2, j++) {
        		int multiple = temp[i];
        		multipleArr[j] = temp[i];
        		
        		if (i < temp.length) {
        			multiple *= temp[i + 1];
            		multipleArr[j] = Math.max(temp[i], temp[i + 1]);
        		}   
        		minCost += multiple;
        	}
    	}
    	return minCost;
    }
}
