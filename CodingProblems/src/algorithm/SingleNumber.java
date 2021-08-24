package algorithm;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 2, 5};
		
		int[] res = singleNumber(nums);
		System.out.println(res[0] + ", " + res[1]);
	}

    public static int[] singleNumber(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	int[] res = new int[2];
    	int idx = 0;
    	
    	for (int n : nums) {
    		if (set.contains(n)) {
    			set.remove(n);
    			continue;
    		} 
    		set.add(n);
		}
    	
    	for (int n : set) 
    		res[idx++] = n;
    		
    	return res;
    }
}
