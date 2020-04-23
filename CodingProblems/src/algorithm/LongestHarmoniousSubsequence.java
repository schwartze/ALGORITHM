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

		Arrays.sort(nums);
		
		// put all nums in map with value of its count
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int n : nums) {
			int count = map.getOrDefault(n, 0);
			map.put(n, ++count);
		}
		
		// find which num appears the most in the array
		int keyCount = 0;
		int key = 0;
		
		for (int n : map.keySet()) {
			if (map.get(n) > keyCount) {
				keyCount = map.get(n);
				key = n;
			}
		}
		
		// find the num which is greater than key by 1,
		// or is smaller than key by 1
		// and add its count into counts of key
		if (map.containsKey(map.getOrDefault(key - 1, 0)) || 
				map.containsKey(map.getOrDefault((key + 1), 0))) {
			int smaller = map.getOrDefault(key - 1, 0);
			int greater = map.getOrDefault((key + 1), 0);
			
			if (smaller > greater)
				keyCount += smaller;
			else 
				keyCount += greater;
		}
		
		return keyCount;
	}
	
}
