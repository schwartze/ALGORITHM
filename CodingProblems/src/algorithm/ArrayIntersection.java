package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
	
    public List<Integer> intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<>();

    	for (int n : nums1) {
    		map.put(n, map.getOrDefault(n, 0) + 1);
    	}
    	
    	List<Integer> result = new ArrayList<>();
    	
    	for (int n : nums2) {
    		if (map.containsKey(n)) {
    			result.add(n);
    			map.put(n, map.get(n) - 1);
    		}
    	}
     	
    	return result;
    }
}
