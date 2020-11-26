package algorithm;

public class OpsArray {

	public static void main(String[] args) {
		int n = 10, start = 5;
		int res = xorOperation(n, start);
		System.out.println(res);
	}
	// Define an array nums where nums[i] = start + 2*i (0-indexed) 
	// and n == nums.length.
    public static int xorOperation(int n, int start) {
    	int opsCount = 1, num = start;
    	
    	while (opsCount++ < n) {
    		num += 2;
    		start ^= num;
    	}
    	return start;
    }
}
