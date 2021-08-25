package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {

	public static void main(String[] args) {
		String s = "tree";
		String s2 = "cccaaa";
		String s3 = "Aabb";
		
		String res = frequencySort(s3);
		System.out.println(res);
	}
	
    public static String frequencySort(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for (char c : s.toCharArray()) {
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	
    	List<int[]> list = new ArrayList<>();
    	
    	for (char key : map.keySet()) {
    		int[] arr = {(int)key, map.get(key)};
    		list.add(arr);
    	}
    	
    	Collections.sort(list, (a, b) -> a[1] == b[1] ? a[0] - b[0]: b[1] - a[1]);
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < list.size(); i++) 
    		for (int j = 0; j < list.get(i)[1]; j++)
    			sb.append((char)(list.get(i)[0]));
    	
    	return sb.toString();
    }
    
}
