package algorithm;

import java.util.Arrays;

public class QueueReconstruction {
	
	public static void main(String[] args) {
		int[][]  people = {
				{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}
			};
	
		reconstructQueue(people);
	}

    public static int[][] reconstructQueue(int[][] people) {
    	int[][] res = new int[people.length][2];
    	Arrays.fill(res, new int[] {-1, -1});
    	
    	for (int i = 0; i < people.length; i++) {
    		int[] person = people[i];
    		
    		if (res[person[1]][0] == -1 && res[person[1]][1] == -1) {
    			res[person[1]] = person;
    			continue;
    		}
    		
    		for (int j = person[1]; j < res.length; j++) {
    			int[] original = res[j];
    			
    			if (original[0] == -1 && original[1] == -1) {
    				res[j] = person;
    				break;
    			}
    			
    			if (original[0] > person[0]) {
    				res[j] = person;
    				person = original;
    			}
    			
    			if (original[1] == person[1]) {
    				
    				if (original[0] > person[0]) {
    					res[j] = person;
    					person = original;
    				} else {
    					original = res[j + 1];
    					res[j + 1] = person;
    					person = original;
    				}
    			}
    		}
    	}
    	
    	return res;
    }
}
