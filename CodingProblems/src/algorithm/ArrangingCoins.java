package algorithm;

public class ArrangingCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins_Math(8));
	}
	
	public static int arrangeCoins(int n) {
		
		int count = 0;
		int index = 1;
		
		while (true) {
			
			if (n < index)
				break;
			
			count++;
			n -= index;	
			index++;
		}
		
		return count;
	}
	
	public static int arrangeCoins_Math(int n) {
		
		return (int)((Math.sqrt(8.0 * n + 1) - 1) / 2);
	}
}
