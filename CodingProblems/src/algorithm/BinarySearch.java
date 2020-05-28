package algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 9;
		
		BinarySearch search = new BinarySearch();
		int n = search.search(nums, target);
		System.out.println(n);
	}
	
    public int search(int[] nums, int target) {
     
    	int start = 0,
    		end = nums.length,
    		mid = (end - start) / 2;
    	
    	// 0 < mid < nums.length
    	while (mid > start && mid < end) {
    		
    		if (nums[mid] == target)
    			return mid;
    		
    		if (nums[mid] > target) {
    			end = mid;
    			mid = mid / 2;
    		}
    		else {
    			start = mid;
    			mid = mid + ((nums.length - mid) / 2);
    		}
    	}
    	
    	return -1;
    }
}
