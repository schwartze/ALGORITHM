package algorithm;

public class ArrayConcatenation {

	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		int[] nums2 = {1, 3, 2, 1};
		
		int[] res = getConcatenation(nums2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] getConcatenation(int[] nums) {
    	int[] result = new int[nums.length * 2];
    	
    	for (int i = 0; i < nums.length; i++) {
    		result[i] = nums[i];
    		result[i + nums.length] = nums[i]; 
    	}
    	return result;
    }
}
