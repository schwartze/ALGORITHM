package algorithm;

public class ArrangingCoins {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(8));
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
}
