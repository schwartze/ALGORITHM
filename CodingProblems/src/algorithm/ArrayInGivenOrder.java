package algorithm;

import java.util.Arrays;

public class ArrayInGivenOrder {
	
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4};
		int[] index = {0, 1, 2, 2, 1};
		
		int[] nums2 = {1, 2, 3, 4, 0};
		int[] index2 = {0, 1, 2, 3, 0};
		
		int[] res = createTargetArray(nums2, index2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	// return a new array with each element 
	// in the given nums array placed in the corresponding index 
	// of the given index array
    public static int[] createTargetArray(int[] nums, int[] index) {
    	int[] res = new int[nums.length];
    	Arrays.fill(res, -1);
    	
    	for (int i = 0; i < index.length; i++) {
			if (res[index[i]] >= 0) {
				int prev = res[index[i]];
				res[index[i]] = nums[i];

    			for (int j = index[i] + 1; prev >= 0 && j < res.length; j++) {
    				int temp = res[j];
    				res[j] = prev;
    				prev = temp;
    			}
    			continue;
    		}
			res[index[i]] = nums[i];
    	}
    	return res;
    }
}
