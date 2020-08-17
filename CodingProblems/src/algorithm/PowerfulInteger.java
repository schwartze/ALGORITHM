package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PowerfulInteger {

	// An integer is powerful if it is equal to x^i + y^j for some integers i >= 0 and j >= 0.
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
     
    	List<Integer> list = new ArrayList<>();
    	int xMax = getMaxPower(x, bound);
    	int yMax = getMaxPower(y, bound);
    	
    	for (int i = 0; i < xMax; i++) {
    	
    		for (int j = 0; j < yMax; j++) {
    		
    			if (Math.pow(x, i) + Math.pow(y, j) > bound)
    				break;

    			list.add((int)(Math.pow(x, i) + Math.pow(y, j)));
    		}
    	}
    	
    	return list;
    }
    
    private int getMaxPower(int value, int bound) {
    	int max = 0;
    	int idx = 0;
    	
    	while (true) {
    		
    		if (Math.pow(value, idx) < bound)
    			idx++;
    		else {
    			max = idx;
    			break;
    		}
    	}
    	return max;
    }
}
