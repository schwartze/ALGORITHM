package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankArray {

	public static void main(String[] args) {
		int[] arr = {40, 10, 20, 30};
		int[] res = arrayRankTransform2(arr);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// HashTable
    public static int[] arrayRankTransform(int[] arr) {
    	Map<Integer, List<Integer>> map = new TreeMap<>();
    	
    	for (int i = 0; i < arr.length; i++) {
    		List<Integer> temp;
    		
    		if (map.containsKey(arr[i])) {
    			temp = map.get(arr[i]);
    			temp.add(i);
    			map.put(arr[i], temp);
    			continue;
    		}
    		temp = new ArrayList<>();
    		temp.add(i);
    		map.put(arr[i], temp);
    	}
    	
    	int i = 1;
    	for (int key : map.keySet()) {
    		for (int pos : map.get(key)) {
    			arr[pos] = i;
    		}
    		i++;
    	}
    	
    	return arr;
    }
    
    
    public static int[] arrayRankTransform2(int[] arr) {
    	int[] copiedArr = arr.clone();
    	Arrays.sort(copiedArr);
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	// put each element of sorted array
    	// size of map incremented as an element is inserted 
    	for (int i = 0; i < arr.length; i++)
    		map.putIfAbsent(copiedArr[i], map.size() + 1);
    	
    	for (int i = 0; i < arr.length; i++)
    		arr[i] = map.get(arr[i]);
    		
    	return arr;
    }
}
