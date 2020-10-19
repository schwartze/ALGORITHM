package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DecompressList {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
	    int[] res = decompressRLElist(nums);
	    
	    for (int n : res)
	    	System.out.print(n + ", ");
	}
	
	// Consider the given nums array is paired with feq and value 
	// generate an array of values which appear freq times
    public static int[] decompressRLElist(int[] nums) {
    	List<Integer> list = new ArrayList<>();

    	for (int i = 0; i < nums.length; i+=2) {
    		int freq = nums[i], value = nums[i + 1], j = 0;
    		
    		while (j < freq) {
    			list.add(value);
    			j++;
    		}
    	}
    	int[] res = new int[list.size()];
    	for (int i = 0; i < list.size(); i++) 
    		res[i] = list.get(i);
    	
    	return res;
    }
}
