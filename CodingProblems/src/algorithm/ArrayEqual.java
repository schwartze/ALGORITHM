package algorithm;

public class ArrayEqual {
	
	public static void main(String[] args) {
		int n = 6;
		int res = minOperations(n);
		System.out.println(res);
	}
	/*
	 * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
	 * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1 to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal. It is guaranteed that all the elements of the array can be made equal using some operations.
	 */
    public static int minOperations(int n) {
    	int targetNumber = (((n - 1) * 2) / 2) + 1;
    	int targetIdx = targetNumber / 2;
    	int result = 0, number = 1;
    	
    	while (targetIdx-- > 0) {
    		result += targetNumber - number;
    		number += 2;
    	}
    	
    	return result;
    }
}
