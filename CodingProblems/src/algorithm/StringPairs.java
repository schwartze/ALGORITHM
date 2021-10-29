package algorithm;

public class StringPairs {

	public static void main(String[] args) {
		String[] nums = {"777","7","77","77"};
		String target ="7777"; 
		
		String[] nums2 = {"123","4","12","34"};
		String target2 ="1234"; 
		
		String[] nums3 = {"1","1","1"};
		String target3 ="11"; 
		
		int count = numOfPairs(nums3, target3);
		System.out.println(count);
	}
	
    public static int numOfPairs(String[] nums, String target) {
    	int pairCount = 0;
    	
    	for (int i = 0; i < nums.length; i++) {
    		
    		for (int j = 0; j < nums.length; j++) {
    			if (i == j) continue;
    			
    			if (target.equals(nums[i] + nums[j]))
    				pairCount++;
    		}
    	}
    	
    	return pairCount;
    }
}
