package algorithm;

public class GeneratedArray {

	public static void main(String[] args) {
		int n = 7;
		int n2 = 2;
		int n3 = 3;
		
		int res = getMaximumGenerated(n3);
		System.out.println(res);
	}
	/*
	 * You are given an integer n. An array nums of length n + 1 is generated in the following way:
		nums[0] = 0
		nums[1] = 1
		nums[2 * i] = nums[i] when 2 <= 2 * i <= n
		nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
		Return the maximum integer in the array nums​​​
	 */
    public static int getMaximumGenerated(int n) {
    	if (n < 2)
    		return n;
    	
    	int[] temp = new int[n + 1];
    	temp[1] = 1;
    	int max = 0;
    	
    	for (int i = 1; i * 2 <= n; i++) {
    		temp[i * 2] = temp[i * 2 / 2];
    		
    		if (i * 2 + 1 <= n) 
    			temp[i * 2 + 1] = temp[i * 2 / 2] + temp[i * 2 / 2 + 1]; 
    	}

    	for (int num : temp)
    		if (num > max)
    			max = num;
    	return max;
    }
}
