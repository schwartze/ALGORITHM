package algorithm;

import java.util.Arrays;

public class TruckLoading {
	
	public static void main(String[] args) {
		int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}}; 
		int truckSize = 10;
				
		int res = maximumUnits(boxTypes, truckSize);
		System.out.println(res);
	}
	/*
	 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
	 * 	numberOfBoxesi is the number of boxes of type i.
	 *	numberOfUnitsPerBoxi is the number of units in each box of the type i.
	 *	You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
	 */
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
    	Arrays.sort(boxTypes, ((a, b) -> b[1] - a[1] >= 0 ? 1 : -1));
    	int units = 0;
    	
    	for (int[] box : boxTypes) {
    		for (int i = 0; i < box[0]; i++) 
    			if (truckSize-- > 0)
    				units += box[1];
    	}
    	
    	return units;
    }
}
