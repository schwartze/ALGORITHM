package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    public int getKth2(int lo, int hi, int k) {
        int[][] arr = new int[hi - lo + 1][2];
    	
    	for (int i = lo, j = 0; i < hi + 1; i++, j++) {
    		int powerValue = getPowerValue2(i);
    		arr[j] = new int[] {powerValue, i}; 
    	}
    	
    	Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    	
    	return arr[k - 1][1];
    }
    
    private int getPowerValue2(int n) {
    	int count = 0;
    	
    	while (n > 1) {
    		n = n % 2 == 0 ? n / 2 : 3 * n + 1;
    		count++;
    	}
    	
    	return count;
    }
   
}
