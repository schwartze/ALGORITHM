package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {

	public static void main(String[] args) {
		// int[] arr = {1, 2, 2, 1, 1, 3};
		// int[] arr = {1, 2};
		int[] arr = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
		
		UniqueOccurrences uOccurrences = new UniqueOccurrences();
		boolean res = uOccurrences.uniqueOccurrences(arr);
		System.out.println(res);
	}
	
    public boolean uniqueOccurrences(int[] arr) {
    	Map<Integer, Integer> map = new HashMap<>(arr.length);

    	for (int n : arr)
    		map.put(n, map.getOrDefault(n, 0) + 1);
    	
    	return map.size() == new HashSet<>(map.values()).size();
    }
}
