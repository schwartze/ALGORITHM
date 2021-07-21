package algorithm;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int[] nums = {1, 3, 5, 6};
		int target = 2;
		
		int res = searchInsert(nums, target);
		System.out.println(res);
	}
	
    public static int searchInsert(int[] nums, int target) {
    	if (nums[0] >= target)
    		return 0;
    	
    	if (nums[nums.length - 1] <= target)
    		return nums.length;
    	
    	int i = 0;
    	for (; i < nums.length; i++)
    		if (nums[i] >= target)
    			break;
    	
    	return i;
    }
}
