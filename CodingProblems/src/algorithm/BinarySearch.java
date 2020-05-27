package algorithm;

public class BinarySearch {

	public static void main(String[] args) {
		int[] nums = {-1,0,3,5,9,12};
		int target = 2;
		
		BinarySearch search = new BinarySearch();
		int n = search.search(nums, target);
		System.out.println(n);
	}
	
    public int search(int[] nums, int target) {
     
    	int mid = nums.length / 2;
    	
    	while (mid > 0 || mid < nums.length) {
    		
    		if (nums[mid] == target)
    			return mid;
    		
    		if (nums[mid] > target)
    			mid = mid / 2;
    		else
    			mid = (nums.length - mid) / 2 + 3;
    	}
    	
    	return -1;
    }
}
