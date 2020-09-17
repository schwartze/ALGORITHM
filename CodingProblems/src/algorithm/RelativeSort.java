package algorithm;

import java.util.Map;
import java.util.TreeMap;

public class RelativeSort {

	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		RelativeSort rSort = new RelativeSort();
		int[] res = rSort.relativeSortArray(arr1, arr2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// Given two integer arrays 
	// 1. arr1 contains duplicates
	// 2. all elements in arr2 are also in arr2
	// 3. arr2 are distinct
	// sort arr1 in the order of arr2 
	// if elements are not included in arr2, they should be sorted in ascending order  
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
    	Map<Integer, Integer> map = new TreeMap<>();
    	
    	for (int n : arr1) {
    		int count = map.getOrDefault(n, 0);
    		map.put(n, count + 1);
    	}
    	int startPos = 0;
    	
    	for (int i = 0; i < arr2.length; i++) {
    		
    		int elCount = map.get(arr2[i]);
    		for (int j = startPos; j < startPos + elCount; j++) {
    			arr1[j] = arr2[i];
    		}
    		startPos += elCount;
    		map.remove(arr2[i]);
    	}
    		
    	for (int key : map.keySet()) {

    		for (int i = startPos; i < startPos + map.get(key); i++) {
    			arr1[i] = key;
    		}
    		startPos += map.get(key);
    	}
    	return arr1;
    }
}
