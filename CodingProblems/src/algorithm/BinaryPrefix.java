package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefix {

	public static void main(String[] args) {
		int[] A = {0,1,1,1,1,1};
		BinaryPrefix bPrefix = new BinaryPrefix();
		List<Boolean> res = bPrefix.prefixesDivBy5(A);
		
		for (boolean ans : res)
			System.out.print(ans + ", ");
	}
	
	// Given an array A of 0s and 1s, 
	// consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number 
	// (from most-significant-bit to least-significant-bit.)
    public List<Boolean> prefixesDivBy5(int[] A) {
    	List<Boolean> res = new ArrayList<>();
    	int binary = 0;
    	
    	for (int bit : A) {
    		binary = (binary << 1 | bit) % 5;
    		res.add(binary == 0);
    	}
    	return res;
    }
}
