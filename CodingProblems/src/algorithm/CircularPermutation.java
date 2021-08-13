package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutation {
	
	public static void main(String[] args) {
		int n = 2, start = 3;
		
		List<Integer> res = circularPermutation(n, start);
		
		for (int num : res)
			System.out.print(num + ", ");
	}

    public static List<Integer> circularPermutation(int n, int start) {
    	List<Integer> result = new ArrayList<>();
    	
    	for (int i = 0; i < 1 << n; i++) {
			result.add(start ^ i ^ i >> 1);
    	}
    	return result;
    }

}
