package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SelfDividing {

	public static void main(String[] args) {
		SelfDividing dividing = new SelfDividing();
		List<Integer> list = dividing.selfDividingNumbers(1, 22);
		
		for (int n : list)
			System.out.println(n);
	}
	
	// a number is self-dividing only if the number has no remainder when it is divided by each of its digit
	// and a self-dividing number must not conatain the digit zero
	// e.g) 128 is a self-dividing number : 128 % 1 == 0, 128 % 2 == 0, 128 % 8 == 0
    public List<Integer> selfDividingNumbers(int left, int right) {

    	List<Integer> res = new ArrayList<>();
    	
    	for (int i = left; i < right + 1; i++) {
    		
    		if (i < 10) {
    			res.add(i);
    			continue;
    		}
    		
    		int val = i / 10;
    		int rem = i % 10;
    		
    		while (true) {
    			
    			if (val == 0 || rem == 0)
    				break;

    			if (i % rem != 0)
    				break;

    			if (val > 10) {
    				val /= 10;
    				rem = val % 10;
    				continue;
    			}
 
    			if (i % val != 0)
    				break;
    			
    			res.add(i);
    			break;
    		}
    	}
    	
    	return res;
    }
}
