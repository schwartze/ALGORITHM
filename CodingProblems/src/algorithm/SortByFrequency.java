package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortByFrequency {

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 3, 2};
		int[] nums2 = {-1, 1, -6, 4, 5, -6, 1, 4, 1};
		int[] res = frequencySort(nums2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] frequencySort(int[] nums) {
    	Map<Integer, Integer> freqMap = new TreeMap<>();
    	Map<Integer, List<Integer>> map = new TreeMap<>();
    	int[] res = new int[nums.length];
    	
    	for (int i = 0; i < nums.length; i++) 
    		freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    	
    	for (int key : freqMap.keySet()) {
    		List<Integer> numList;
    		
    		if (!map.containsKey(freqMap.get(key))) {
    			numList = new ArrayList<>();
    			numList.add(key);
    			map.put(freqMap.get(key), numList);
    			continue;
    		}
    		
    		numList = map.get(freqMap.get(key));
    		numList.add(key);
    	}
    	
    	int idx = 0;
    	for (int freq : map.keySet()) {
    		List<Integer> list = map.get(freq);
    		
    		for (int j = list.size() - 1; j >= 0; j--)
    			for (int i = 0; i < freq; i++) 
    				res[idx++] = list.get(j);
    	}
    	
    	return res;
    }
}
