package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SongPair {

	public static void main(String[] args) {
		int[] time = {30, 20, 150, 100, 40};
		
		SongPair sPair = new SongPair();
		int res = sPair.numPairsDivisibleBy60(time);
		System.out.println(res);
	}
	
	// Return the number of pairs which makes its sum divisible by 60
    public int numPairsDivisibleBy60(int[] time) {
    	Map<Integer, Integer> songMap = new HashMap<>();
    	int res = 0;
    	
    	for (int i = 0; i < time.length; i++) {
    		
    		for (int j = i + 1; j < time.length; j++) {
    			int sum = time[i] + time[j];
    			if (sum % 60 != 0)
    				continue;
    			songMap.put(sum, songMap.getOrDefault(sum, 0) + 1);
    		}
    	}
    	
    	for (int num : songMap.keySet())
    		res += songMap.get(num);
    	
    	return res;
    }
}
