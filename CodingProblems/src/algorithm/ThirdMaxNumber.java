package algorithm;

import java.util.HashSet;

public class ThirdMaxNumber {

	public static void main(String[] args) {
		int[] num = {1, 2, 3};
		System.out.println(getThirdMaxNumber(num));
	}
	
	public static int getThirdMaxNumber(int[] numbers) {
		
		HashSet<Integer> set = new HashSet<>();
		int max = Integer.MIN_VALUE;
		
		// if the given array has less than three numbers: return the max of array
		for (int n : numbers)
			if (n > max)
				max = n;
		
		// else: find the third max number in the array
		int round = 3;
		
		while (round > 0) {
			
			for (int n : numbers) {
				
				if (n > max && !set.contains(n))
					max = n;
			}
			if (set.size() == 2)
				break;
			
			set.add(max);
			
			round--;
			max = Integer.MIN_VALUE;
		}
		return max;
	}
}
