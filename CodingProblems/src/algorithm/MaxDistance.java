package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

	public static void main(String[] args) {
		int[] seats = {1,0,0,0,1,0,1};
		int[] seats2 = {1,0,0,0};
		
		
		MaxDistance mDistance = new MaxDistance();
		int res = mDistance.maxDistToClosest(seats3);
		System.out.println(res);
	}
	
    public int maxDistToClosest(int[] seats) {
    	int onePos = 0;
    	int res = 0;
    	
    	for (int i = 0; i < seats.length; i++) {
    		int min = seats.length;
    		
    		if (seats[i] == 1) {
    			onePos = i;
    			continue;
    		}
    		
    		int j = i;
    		while (seats[j] != 1 && j < seats.length - 1) {
    			j++;
    		}
    		
    		if (seats[j] == 1)
    			min = Math.min(i - onePos, j - i);
    		else
    			min = Math.max(i - onePos, j - i);
    			
    		res = Math.max(res, min);
    	}
    	
    	return res;
    }
}
