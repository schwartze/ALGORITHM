package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MoveChips {

	public static void main(String[] args) {
		int[] position = {1, 1000000000}; // 1
		int[] position2 = {2, 2, 2, 3, 3}; // 2 
		int[] position3 = {1, 2, 3}; // 1
		int[] position4 = {3, 3, 1, 2, 2}; // 2
		int[] position5 = {10,3,3,1,6,2,1,10,6,6}; // 4
		int[] position6 = {6,4,7,8,2,10,2,7,9,7}; // 4
		
		int res = minCostToMoveChips(position3);
		System.out.println(res);
	}
	
    public static int minCostToMoveChips(int[] position) {
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int chip : position) 
    		map.put(chip, map.getOrDefault(chip, 0) + 1);
    	
    	Integer[] keyArr = map.keySet().toArray(new Integer[map.keySet().size()]);
    	int evenCost = 0, oddCost = 0;
    	int num = keyArr[0];
    	
    	while (num <= keyArr[keyArr.length - 1]) {
    		if (map.containsKey(num))
    			evenCost += map.get(num);
    		
    		if (map.containsKey(num + 1))
        		oddCost += map.get(num + 1);
    		num += 2;
    	}

    	return evenCost > oddCost ? oddCost : evenCost;
    }
}
