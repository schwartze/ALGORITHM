package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AbsDifference {

	public static void main(String[] args) {
 		int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
//		int[] arr = {1, 3, 6, 10, 15};
//		int[] arr = {4, 2, 1, 3};
		
		AbsDifference aDiff = new AbsDifference();
		List<List<Integer>> res = aDiff.minimumAbsDifference2(arr);
		
		for (List<Integer> list : res) {
			for (int n : list)
				System.out.print(n + ", ");
			System.out.println();
		}
	}

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	Map<Integer, Integer> map = new TreeMap<>();
    	int minDiff = Integer.MAX_VALUE;
    	Arrays.sort(arr);
    	
    	for (int i = 1; i < arr.length; i++) {

    		int diff = Math.abs(arr[i] - arr[i - 1]);
			minDiff = Math.min(minDiff, diff);

			if (diff == minDiff)
				map.put(arr[i - 1], arr[i]);
    	}
    	
    	for (int key : map.keySet()) {
    		
    		if (Math.abs(key - map.get(key)) > minDiff) 
    			continue;
    		
			List<Integer> subList = new ArrayList<>();
			subList.add(key);
			subList.add(map.get(key));
			res.add(subList);
    	}

    	return res;
    }
}
