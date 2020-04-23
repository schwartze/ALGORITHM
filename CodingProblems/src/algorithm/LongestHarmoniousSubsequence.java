package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		int[] nums = {1,3,2,2,5,2,3,7};
		
		LongestHarmoniousSubsequence LHS = new LongestHarmoniousSubsequence();
		int result = LHS.findLHS(nums);
		System.out.println(result);
	}
	
	public int findLHS(int[] nums) {

		// put all nums in map with value as its count
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int n : nums) {
			int count = map.getOrDefault(n, 0);
			map.put(n, ++count);
		}
		
		// find the length of longest subsequence
		int keyCount = 0;
		
		for (int key : map.keySet()) {
			
			if (map.containsKey(key + 1))
				keyCount = Math.max(keyCount, (map.get(key + 1) + map.get(key)));
		}
		return keyCount;
	}
}
