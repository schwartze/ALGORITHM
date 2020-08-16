package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LargestTime {
	
	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[] B = {5, 5, 5, 5};
		
		LargestTime lTime = new LargestTime();
		String res = lTime.largestTimeFromDigits(B);
		
		System.out.println(res);
	}

	public String largestTimeFromDigits(int[] A) {
     
		// AB:CD
		// possible digits for each position
		// A: 0, 1, 2 
		// B: 0, 1, 2, 3 
		// C: 0, 1, 2, 3, 4, 5
		// D: 0, 1, 2, 3, ..., 8, 9
		
		Set<Integer> idxSet = new HashSet<>();
		List<Integer> digits = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 10; i++)
			digits.add(i);

		int hour1 = getMaxDigits(A, digits.subList(0, 3), idxSet);
		int hour2 = getMaxDigits(A, digits.subList(0, 4), idxSet);
		int min1 = getMaxDigits(A, digits.subList(0, 6), idxSet);
		int min2 = getMaxDigits(A, digits.subList(0, 10), idxSet);
		
		if (hour1 == 10 || hour2 == 10 || min1 == 10 || min2 == 10)
			return "NA";
		
		sb.append(Integer.toString(hour1));
		sb.append(Integer.toString(hour2));
		sb.append(":");
		sb.append(Integer.toString(min1));
		sb.append(Integer.toString(min2));
		
		return sb.toString();
    }
	
	private int getMaxDigits(int[] A, List<Integer> digits, Set<Integer> set) {
		
		for (int i = digits.size() - 1; i >= 0; i--) {
			
			for (int j = 0; j < A.length; j++) {
				
				if (A[j] == digits.get(i) && !set.contains(j)) {
					set.add(j);
					return A[j];
				}
			}
		}
		return 10;
	}
}
