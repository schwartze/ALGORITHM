package algorithm;

import java.util.HashSet;
import java.util.TreeSet;

public class ThirdMaxNumber {

	public static void main(String[] args) {
		int[] num = {1, 2, 3, 2};
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

	public static int getThirdMax(int[] numbers) {
		// TreeSet: store values in ascending order
		TreeSet<Integer> set = new TreeSet<>();
		
		for (int n : numbers) {
			set.add(n);
		}
		
		// if the given array has less than three numbers 
		// return the max number
		if (set.size() < 3)
			return set.last();
		
		// remove first and second max numbers
		set.remove(set.last());
		set.remove(set.last());
		
		return set.last();
	}

	public int getThirdMaxValue(int[] num) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		
		for (Integer n : num) {
			
			// when there are duplicate values in array continue the loop
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max2 = max1;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		// max3 being null means there are less than 3 values in the given array
		// in that case, return the max value (not third max)
		return max3 == null ? max1 : max3;
	}
	
}
