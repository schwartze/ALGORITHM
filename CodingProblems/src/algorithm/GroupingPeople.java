package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingPeople {

	public static void main(String[] args) {
		int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
		int[] groupSizes2 = {2, 1, 3, 3, 3, 2};
		List<List<Integer>> res = groupThePeople(groupSizes2);
		
		for (List<Integer> list : res) {
			for (int n : list)
				System.out.print(n);
			System.out.println();
		}
				
	}
	/*
	 * There are n people that are split into some unknown number of groups. 
	 * Each person is labeled with a unique ID from 0 to n - 1.
	 * You are given an integer array groupSizes, where groupSizes[i] is the size of the group 
	 * that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
	 */
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	List<List<Integer>> res = new ArrayList<>();
    	
    	for (int i = 0; i < groupSizes.length; i++) {
    		List<Integer> idxList;
    		
    		if (map.containsKey(groupSizes[i])) {
    			idxList = map.get(groupSizes[i]);
    			idxList.add(i);
    			continue;
    		}
    		idxList = new ArrayList<>();
    		idxList.add(i);
    		map.put(groupSizes[i], idxList);
    	}
    	
    	for (int key : map.keySet()) {
    		
    		if (key == map.get(key).size()) {
    			res.add(map.get(key));
    			continue;
    		}
    		List<Integer> idxList = map.get(key);

    		for (int i = 0; i < idxList.size(); i += key) 
    			res.add(idxList.subList(i, i + key));
    	}
    	
    	return res;
    }
}
