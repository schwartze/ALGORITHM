package algorithm;

public class SpecialArray {

	public static void main(String[] args) {
		int[] nums = {0, 4, 3, 0, 4};
		int[] nums2 = {3, 6, 7, 7, 0};
		int[] nums3 = {0, 0};
		int[] nums4 = {3, 5};
		
		int res = specialArray(nums);
		System.out.println(res);
	}
	// nums is considered special if there exists a number x 
	// such that there are exactly x numbers in nums 
	// that are greater than or equal to x.
    public static int specialArray(int[] nums) {
    	int[] countArray = new int[101];
    	int res = -1;
    	
    	for (int n : nums) 
    		for (int i = 0; i <= n; i++) 
    			countArray[i]++;
    	
    	for (int i = 0; i < countArray.length; i++) {
    		if (countArray[i] == i) {
    			res = i;
    			break;
    		}
    	}
    	return res;
    }
}
