package algorithm;

public class MoveZero {

	public void moveZeroes(int[] numbers) {
		int nonZeroAt = 0;

		// move all non-zeros to the beginning of the array 
		for (int i = 0; i < numbers.length; i++) {
			
			if (numbers[i] != 0)
				numbers[nonZeroAt] = numbers[i];
		}
		
		// starting from index where nonZero ends, add 0's at the end of array
		for (int i = nonZeroAt; i < numbers.length; i++) {
			numbers[i] = 0;
		}
	}
}
