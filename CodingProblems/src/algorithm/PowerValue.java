package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PowerValue {

	public static void main(String[] args) {
		int lo = 10, hi = 20, k = 5;
		
		int res = getKth(lo, hi, k);
		System.out.println(res);
	}
	
    public static int getKth(int lo, int hi, int k) {
    	List<int[]> list = new ArrayList<>();
    	
    	for (int i = lo; i < hi + 1; i++) {
    		int[] pair = new int[2];
    		pair[0] = i;
    		pair[1] = getPowerValue(i);
    		list.add(pair);
    	}
    	
    	Collections.sort(list, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    	
    	return list.get(k - 1)[0];
    }
    
    private static int getPowerValue(int num) {
    	int step = 0;
    	
    	while (num > 1) {
    		if (num % 2 == 0) {
    			num /= 2;
    		} else {
    			num = num * 3 + 1;
    		}
    		step++;
    	}
    	
    	return step;
    }
   
}
