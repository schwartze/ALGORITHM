package algorithm;

import java.util.Arrays;
import java.util.TreeMap;

public class RelativeRanks {

	public static void main(String[] args) {
		RelativeRanks ranks = new RelativeRanks();
		int[] nums = {5, 8, 4, 2, 9};
		String[] results = ranks.findRelativeRanks(nums);
		
		for (String res : results)
			System.out.print(res + ", ");
	}
	
    public String[] findRelativeRanks(int[] nums) {
    	String[] results = new String[nums.length];
    	String[] medals = new String[3];
    	medals[0] = "Gold Medal";
    	medals[1] = "Silver Medal";
    	medals[2] = "Bronze Medal";
    	
    	// store each num and its position into map
    	TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) 
    		map.put(nums[i], i);
    	
    	// sort nums in ascending order
    	Arrays.sort(nums);
    	
    	// assign ranks to each num
    	for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
    		
    		if (j < 3) {
    			results[map.get(nums[i])] = medals[j];
    		}
    		else 
    			results[map.get(nums[i])] = (j + 1) + "";
    	}
    	
    	return results;
    }
}
