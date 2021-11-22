package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    
    public int[][] reconstructQueue2(int[][] people) {
    	Arrays.sort(people, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    	
    	List<int[]> peopleList = new ArrayList<>();
    	
    	for (int[] person : people) {
    		
    		if (peopleList.size() == 0) {
    			peopleList.add(person);
    			continue;
    		}
    		int numOfTallerPerson = 0; 
    		
    		for (int i = 0; i < peopleList.size(); i++) {
    			int[] curr = peopleList.get(i);
    			
    			if (curr[0] > person[0]) {
    				numOfTallerPerson++;
    			}
    			
    			if (numOfTallerPerson == curr[1]) {
    				
    				if (peopleList.size() > i) {
        				peopleList.add(i, curr);;
    				} else {
    					peopleList.add(curr);
    				}
    			}
    			
    		}
    	}
    	
    	int[][] res = new int[peopleList.size()][2];
    	for (int i = 0; i < peopleList.size(); i++) {
    		res[i] = peopleList.get(i);
    	}
    	return res;
    }
}
