package algorithm;

public class GoodPairs {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1};
		int res = numGoodPairs(nums);
		System.out.println(res);
	}
	// two numbers are good pairs if they are identical and 
	// the index of second element is greater than that of first  
    public static int numIdenticalPairs(int[] nums) {
    	int count = 0;
    	
    	for (int i = 0; i < nums.length; i++)
    		for (int j = i + 1; j < nums.length; j++)
    			if (nums[i] == nums[j])
    				count++;
    	return count;
    }
    
    public static int numGoodPairs(int[] nums) {
    	int res = 0;
    	int[] numbers = new int[101];
    	
    	for (int n : nums) {
    		res += numbers[n];
    		numbers[n]++;
    	}
    	
    	return res;
    }
}
