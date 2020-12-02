package algorithm;

import java.util.HashSet;
import java.util.Set;

public class SumOfElements {

	public static void main(String[] args) {
		int[] numbers = {5, 0, 2, 7};
		int[] res = getUniqueSum(numbers);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	public static int[] getUniqueSum(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < numbers.length; i++) 
			for (int j = i + 1; j < numbers.length; j++) 
				set.add(numbers[i] + numbers[j]);
		
		int[] res = new int[set.size()];
		int i = 0;
		
		for (int sum : set) {
			res[i] = sum;
			i++;
		}
		return res;
	}
}
