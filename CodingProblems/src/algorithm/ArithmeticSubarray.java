package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarray {

	public static void main(String[] args) {
		int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
		int[] l = {0,1,6,4,8,7};
		int[] r = {4,4,9,7,9,10};
		
		int[] nums2 = {-3,-6,-8,-4,-2,-8,-6,0,0,0,0};
		int[] l2 = {5,4,3,2,4,7,6,1,7};
		int[] r2 = {6,5,6,3,7,10,7,4,10};
		
		List<Boolean> resultList = checkArithmeticSubarrays(nums2, l2, r2);
		for (boolean result : resultList)
			System.out.print(result + ", ");
	}
	/*
	 * A sequence of numbers is called arithmetic if it consists of at least two elements, 
	 * and the difference between every two consecutive elements is the same. 
	 * More formally, a sequence s is arithmetic if and only if s[i+1] - s[i] == s[1] - s[0] for all valid i.
	 */
	
    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    	List<Boolean> result = new ArrayList<>();
    	
    	for (int i = 0; i < l.length; i++) {
    		int from = l[i], to = r[i];
    		
    		int[] subArray = new int[to - from + 1];
    		subArray = Arrays.copyOfRange(nums, from, to + 1);
    		Arrays.sort(subArray);

    		boolean isArithmetic = true;
    		if (subArray.length > 2) {
        		int gap = subArray[1] - subArray[0];
        		
        		for (int j = 1; j < subArray.length - 1; j++) {
        			if (subArray[j + 1] - subArray[j] != gap) {
        				isArithmetic = false;
        				break;
        			}
        		}
    		}
    		result.add(isArithmetic);
    	}
    	return result;
    }
}
