package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DominoPairs {

	public static void main(String[] args) {
		int[][] dominoes = {
				{1, 2},
				{1, 2},
				{1, 1},
				{1, 2},
				{2, 2}
		};
		DominoPairs dPairs = new DominoPairs();
		int res = dPairs.numEquivDominoPairs(dominoes);
		System.out.println(res);

	}
	// pairs are dominoes if and only if [a, b], [c, d]
	// (a == c and b == d) o(r a == d and b == c)
    public int numEquivDominoPairs(int[][] dominoes) {
    	Map<int[], Integer> map = new HashMap<>();
    	int res = 0;
    	map.put(dominoes[0], 1);

    	for (int i = 1; i < dominoes.length; i++) {
    		Map.Entry<int[], Integer> entry;
			Iterator<Map.Entry<int[], Integer>> it;
			
			it = map.entrySet().iterator();
			while (it.hasNext()) {
				entry = it.next();

				if (entry.getKey()[0] == dominoes[i][0] && entry.getKey()[1] == dominoes[i][1]) {
					int count = entry.getValue();
					entry.setValue(count + 1);
					continue;
				}
				
				if (entry.getKey()[0] == dominoes[i][1] && entry.getKey()[1] == dominoes[i][0]) {
					int count = entry.getValue();
					entry.setValue(count + 1);
					continue;
				}
				map.put(dominoes[i], 1);
			}
    	}
    	
    	for (int[] key : map.keySet()) {
    		int count = map.get(key);
    		
    		if (count > 1)
    			res += (count * (count - 1)) / 2;
    	}
    	return res;
    }
}
