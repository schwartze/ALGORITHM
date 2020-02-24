package algorithm;

public class EqualArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(getMinimunMoves(arr));
	}
	
	public static int getMinimunMoves(int[] arr) {

		int sum = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
		
			if (arr[i] < min)
				min = arr[i];
			
			sum += arr[i];
		}
			
		return sum - (min * arr.length);
	}
}
