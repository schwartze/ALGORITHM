package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CircularTrack {

	public static void main(String[] args) {
		int[] rounds = {3,2,1,2,1,3,2,1,2,1,3,2,3,1};
		int n = 3;
		
		int[] rounds2 = {1, 3, 1, 2};
		int n2 = 4;
		
		int[] rounds3 = {2,1,2,1,2,1,2,1,2};
		int n3 = 2;
		
		int[] rounds4 = {1, 3, 5, 7};
		int n4 = 7;
		
		int[] rounds5 = {2, 3, 2, 3};
		int n5 = 4;
		
		int[] rounds6 = {3, 2};
		int n6 = 5;
		
		
		List<Integer> res = mostVisited(n6, rounds6);
		
		for (int num : res)
			System.out.print(num + ", ");
	}
	
    public static List<Integer> mostVisited(int n, int[] rounds) {
    	int[] countArray = new int[n];
    	
    	countArray[rounds[0] - 1]++;
    	for (int i = 0; i < rounds.length - 1; i++) {
    		int currentTrack = rounds[i];
    		int nextTrack = rounds[i + 1];
    		
    		while (currentTrack != nextTrack) {
    			if (currentTrack >= n) {
    				currentTrack = 1;
    			} else {
    				currentTrack++;
    			}
    			countArray[currentTrack - 1]++;
    		}
    	}
    		
    	int maxCount = 0;
    	List<Integer> result = new ArrayList<>();
    	
    	for (int num : countArray)
    		if (num > maxCount)
    			maxCount = num;
    	
    	for (int i = 0; i < countArray.length; i++)
    		if (countArray[i] == maxCount)
    			result.add(i + 1);
    	
    	return result;
    }
}
