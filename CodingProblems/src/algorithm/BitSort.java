package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BitSort {

	public static void main(String[] args) {
		int[] arr = {2,3,5,7,11,13,17,19};
		int[] res = sortByBits(arr);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] sortByBits(int[] arr) {
    	int[] sortedArr = arr.clone();
    	Arrays.sort(sortedArr);
    	Map<Integer, List<Integer>> map = new TreeMap<>();
    	
    	for (int i = 0; i < sortedArr.length; i++) {
    		
    		int bitCount = Integer.bitCount(sortedArr[i]);
    		List<Integer> list;
    		if (map.containsKey(bitCount)) {
    			list = map.get(bitCount);
    			list.add(sortedArr[i]);
    			continue;
    		}
    		list = new ArrayList<>();
    		list.add(sortedArr[i]);
    		map.put(bitCount, list);
    	}
    	
    	int idx = 0;
    	for (int bCount : map.keySet()) {
    		
    		List<Integer> list = map.get(bCount);
    		for (int i = 0; i < list.size(); i++) {
    			arr[idx++] = list.get(i);
    		}
    	}
    	return arr;
    }
}
