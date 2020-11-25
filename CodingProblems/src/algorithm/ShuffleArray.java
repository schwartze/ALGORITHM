package algorithm;

public class ShuffleArray {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 4, 3, 2, 1};
		int n = 4;
		
		int[] res = shuffle(nums, n);
		
		for (int num : res)
			System.out.print(num + ", ");
	}
	// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
	// Return the array in the form [x1,y1,x2,y2,...,xn,yn].
    public static int[] shuffle(int[] nums, int n) {
    	int[] res = new int[nums.length];
    	
    	for (int i = 0, j = 0; i < nums.length; i += 2) {
    		res[i] = nums[j++];
    		res[i + 1] = nums[n++];
    	}
    	return res;
    }
}
