package algorithm;

public class SumOfAbsoluteDifferences {

	public static void main(String[] args) {
		int[] nums = {2, 3, 5};
		int[] nums2 = {1, 4, 6, 8, 10};
		int[] res = getSumAbsoluteDifferences(nums2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] getSumAbsoluteDifferences(int[] nums) {
    	int[] res = new int[nums.length];
    	
    	
    	for (int i = 0; i < nums.length; i++) {

    		for (int j = 0; j < nums.length; j++) {
    		
    			res[i] += Math.abs(nums[i] - nums[j]);
    		}
    	}
    	
    	return res;
    }
}
