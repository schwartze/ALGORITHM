package algorithm;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 4;
		
		int res = climbStairs(n);
		System.out.println(res);
	}
	
    public static int climbStairs(int n) {
    	int[] arr = new int[n + 1];
    	arr[0] = 1;
    	arr[1] = 1;
    	
    	for (int i = 2; i <= n; i++) {
    		arr[i] = arr[i - 1] + arr[i - 2];
    	}
    	
    	return arr[n];
    }
}
