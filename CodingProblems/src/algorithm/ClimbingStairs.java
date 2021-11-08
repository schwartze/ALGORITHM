package algorithm;

public class ClimbingStairs {

	public static void main(String[] args) {
		int n = 4;
		
		int res = getDifferentWays(n);
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

    
    public static int getDifferentWays(int n) {
    	int[] stairs = new int[45 + 1];
    	stairs[1] = 1;
    	stairs[2] = 2;
    	helper(stairs, 3, n);
    	return stairs[n];
    }
    
    private static void helper(int[] arr, int n, int max) {
    	arr[n] = arr[n - 1] + arr[n - 2];
    	
    	if (n >= max)
    		return;
    	
    	helper(arr, n + 1, max);
    }
}
