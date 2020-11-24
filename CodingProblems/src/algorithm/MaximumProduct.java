package algorithm;

import java.util.Arrays;

public class MaximumProduct {

	public static void main(String[] args) {
		int[] nums = {1, 5, 4, 5};
		int res = getMaxProduct(nums);
		System.out.println(res);
	}
	
    public static int maxProduct(int[] nums) {
    	Arrays.sort(nums);
    	
    	return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
    
    
    public static int getMaxProduct(int[] nums) {
    	int m = 0, n = 0;
    	
    	for (int num : nums) {
    		
    		if (num > m) {
    			n = m;
    			m = num;
    		} else if (num > n) {
    			n = num;
    		}
    	}
    	return (m - 1) * (n - 1);
    }
}
