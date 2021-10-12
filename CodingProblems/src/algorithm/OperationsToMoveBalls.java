package algorithm;

import java.util.ArrayList;
import java.util.List;

public class OperationsToMoveBalls {
	
	public static void main(String[] args) {
		String boxes = "001011";
		String boxes2 = "110";
		
		int[] res = minOperations(boxes2);
		for (int n : res)
			System.out.print(n + ", ");
	}

    public static int[] minOperations(String boxes) {
    	int[] res = new int[boxes.length()];
    	
    	List<Integer> ballList = new ArrayList<>();
    	
    	for (int i = 0; i < boxes.length(); i++) {
    		if (boxes.charAt(i) == '1') {
    			ballList.add(i);
    		}
    	}
    	
    	for (int i = 0; i < boxes.length(); i++) {
    		
    		for (int idx : ballList) {
    			if (idx == i) continue;
    			res[i] += Math.abs(idx - i);
    		}
    	}
    	return res;
    }
}
