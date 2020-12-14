package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CircularTrack {

	public static void main(String[] args) {
		int[] rounds = {3,2,1,2,1,3,2,1,2,1,3,2,3,1};
		int n = 3;
		List<Integer> res = mostVisited(n, rounds);
		
		for (int num : res)
			System.out.print(num + ", ");
	}
	
    public static List<Integer> mostVisited(int n, int[] rounds) {
    	int[] temp = new int[n];
    	
    	for (int i = 0; i < rounds.length - 1; i++) {
    		int k = i == rounds.length - 2 ? 1 : 0;
    		for (int j = 0; j < (int)Math.abs(rounds[i] - rounds[i + 1]) + k; j++) {
    			if ((rounds[i] + j) % n == 0) {
    				temp[temp.length - 1]++;
    				continue;
    			}
    			temp[(rounds[i] + j) % n - 1]++;
    		}
    	}
    	int max = 0;
    	List<Integer> result = new ArrayList<>();
    	
    	for (int round : temp)
    		max = Math.max(round, max);
    	
    	for (int i = 0; i < temp.length; i++) {
    		if (temp[i] == max) {
				result.add(i + 1);
    		}
    	}
    	return result;
    }
}
