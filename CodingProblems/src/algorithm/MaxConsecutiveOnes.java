package algorithm;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		MaxConsecutiveOnes maxOnes = new MaxConsecutiveOnes();
		int[] nums = {1, 1, 0, 1, 1, 1};
		int result = maxOnes.getMaxConsOnes(nums);
		
		System.out.println(result);
		
	}
	
	public int getMaxConsOnes(int[] nums) {
		int max = 0;
		int oneCount = 0;
		
		for (int n : nums) {
			max = Math.max(max, oneCount = n == 0 ? 0 : ++oneCount);
		}
		
		return max;
	}
}
