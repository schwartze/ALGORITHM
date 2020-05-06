package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch {

	public static void main(String[] args) {
		int[] nums = {1,2, 2, 4};
		
		SetMismatch setMismatch = new SetMismatch();
		int[] res = setMismatch.findErrorNums(nums);
		
		for (int n : res)
			System.out.println(n);
		
	}
	
    public int[] findErrorNums(int[] nums) {
     
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int[] res = new int[2];
    	
    	Arrays.sort(nums);
    	
    	// put everything into a map with count
    	for (int i = 0; i < nums.length; i++) {
    		
    		int count = map.getOrDefault(nums[i], 0);
    		map.put(nums[i], ++count);
    	}
    	
    	// find duplicate
    	for (int n : nums) {
    		
    		if (map.get(n) > 1)
    			res[0] = n;
    	}
    	
    	// find missing number
    	for (int i = nums[0]; i < nums.length + 1; i++) {
    		
    		if (!map.containsKey(i))
    			res[1] = i;
    	}
    	
    	return res;
    }
}
