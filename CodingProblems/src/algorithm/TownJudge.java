package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TownJudge {

	public static void main(String[] args) {
		int N = 3;
		int[][] trust = {
				{1, 3},
				{1, 4},
				{2, 3},
				{2, 4},
				{4, 3}
				};
		
		TownJudge townJudge = new TownJudge();
		int res = townJudge.findJudge(N, trust);
		System.out.println(res);
	}
	
    public int findJudge(int N, int[][] trust) {
    	int judge = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	Set<Integer> set = new HashSet<>();
    	
    	// #1. A judge trusts nobody 
    	for (int[] pair : trust)
    		set.add(pair[0]);
    	
    	for (int i = 1; i < N + 1; i++)
    		if (!set.contains(i))
    			judge = i;
    	
    	// #2. Everyone trusts the judge
    	for (int[] pair : trust) {
    		if (map.containsKey(pair[0]) && map.get(pair[0]) == judge)
    			continue;
    		map.put(pair[0], pair[1]);
    	}
    	
    	for (int key : map.keySet())
    		if (map.get(key) != judge)
    			judge = -1;
    	
    	return judge;
    }
}
