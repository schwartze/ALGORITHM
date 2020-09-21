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
    	Map<Integer, Integer> map = new HashMap<>();
    	int res = 0;

    	for (int[] domino : dominoes) {
    		int num = Math.max(domino[0], domino[1]) * 10 + Math.max(domino[1], domino[0]);
    		map.put(num, map.getOrDefault(num, 0) + 1);
    	}
    	
    	for (int value : map.values()) {
    		res += value * (value - 1) / 2;
    	}
    	
    	return res;
    }
}
