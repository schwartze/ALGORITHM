package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UserActive {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] res = new int[k];
		Map<Integer, Set<Integer>> map = new HashMap<>();
		
		for (int[] log : logs) {
			if (map.containsKey(log[0])) {
				Set<Integer> set = map.get(log[0]);
				set.add(log[1]);
				continue;
			}
			Set<Integer> newSet = new HashSet<>();
			newSet.add(log[1]);
			map.put(log[0], newSet);
		}
		
		for (Set<Integer> set : map.values()) 
			res[set.size() - 1]++;
		
    	return res;
    }
}
