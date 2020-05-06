package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch {

	public static void main(String[] args) {
		int[] nums = {2, 2};
		
		SetMismatch setMismatch = new SetMismatch();
		int[] res = setMismatch.findErrorNums(nums);
		
		for (int n : res)
			System.out.println(n);
		
	}
	
    public int[] findErrorNums(int[] nums) {
     
    	HashMap<Integer, Integer> map = new HashMap<>();
    	int[] res = new int[2];
    	
    	// put everything into a map with count
    	for (int i = 0; i < nums.length; i++) {
    		
    		int count = map.getOrDefault(nums[i], 0);
    		map.put(nums[i], ++count);
    	}
    	
    	// find missing number & duplicate
    	for (int i = 1; i < nums.length + 1; i++) {
    		
    		if (map.containsKey(i)) {

    			if (map.get(i) > 1)
    				res[0] = i;
    		} else {
    			res[1] = i;
    		}
    	}
    	
    	return res;
    }
    
    // #2: Brute force 
    public int[] findErrorNums2(int[] nums) {
    	int dup = -1;
    	int missing = -1;
    	
    	for (int i = 0; i < nums.length + 1; i++) {
    		int count = 0;
    		
    		for (int j = 0; j < nums.length; j++) {
    			if (nums[j] ==i)
    				count++;
    		}
    		if (count == 2)
    			dup = i;
    		else if (count == 0)
    			missing = i;
    	}
    	
    	return new int[] {dup, missing};
    }
    
    // #3. Sorting
    public int[] findErrorNums3(int[] nums) {
    	Arrays.sort(nums);
    	
    	int dup = -1;
    	int missing = -1;
    	
    	for (int i = 1; i < nums.length; i++) {
    		
    		if (nums[i] == nums[i - 1])
    			dup = nums[i];
    		else if (nums[i] > nums[i - 1] + 1)
    			missing = nums[i - 1] + 1;
    	}
    	
    	return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
}
