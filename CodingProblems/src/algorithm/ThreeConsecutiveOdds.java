package algorithm;

public class ThreeConsecutiveOdds {

	public static void main(String[] args) {
		int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
		boolean res = threeConsecutiveOdds(arr);
		System.out.println(res);
	}
	
    public static boolean threeConsecutiveOdds(int[] arr) {
    	
    	for (int i = 2; i < arr.length; i++) 
    		if (arr[i] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i - 2] % 2 != 0)
    			return true;
    	
    	return false;
    }
}
