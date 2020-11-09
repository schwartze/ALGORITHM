package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
	
	public static void main(String[] args) {
		int[] nums = {6};
		List<Integer> res = minSubsequence(nums);
		
		for (int n : res)
			System.out.print(n + ", ");
		
	}

	// Return a subsequence of the array whose sum of element is strickly greater 
	// than the sum of the non included elements in such subsequence 
    public static List<Integer> minSubsequence(int[] nums) {
    	int sum = 0, seqSum = 0;
    	for (int n : nums)
    		sum += n;
    	
    	Arrays.sort(nums);
    	List<Integer> res = new ArrayList<>();
    	
    	for (int i = nums.length - 1; i >= 0; i--) {
    		res.add(nums[i]);
    		sum -= nums[i];
    		seqSum += nums[i];

    		if (seqSum > sum)
    			break;
    	}
    	return res;
    }
}
