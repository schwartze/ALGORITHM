package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNum {

	public String getLargestNumber(int[] numbers) {
		Integer[] arr = new Integer[numbers.length];
		
		for (int i = 0; i < numbers.length; i++)
			arr[i] = numbers[i];
		
		Arrays.sort(arr, new NumberSort());
		StringBuilder sb = new StringBuilder();
		
		for (int n : arr)
			sb.append(n);
		
		return sb.toString();
	}
	
	class NumberSort implements Comparator<Integer> {

		@Override
		public int compare(Integer num1, Integer num2) {
			int number1 = Integer.parseInt(num1 + num2 + "");
			int number2 = Integer.parseInt(num2 + num1 + "");
			
			return number1 - number2;
		}

	}
}
