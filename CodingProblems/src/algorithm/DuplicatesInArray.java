package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DuplicatesInArray {

	public static void main(String[] args) {
		int[] nums = {1};
		
		List<Integer> res = findDuplicates(nums);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static List<Integer> findDuplicates(int[] nums) {
    	int[] numArr = new int[100001];
    	List<Integer> res = new ArrayList<>();
    	
    	for (int n : nums) {
    		if (numArr[n] > 0) {
    			res.add(n);
    		} else {
    			numArr[n]++;
    		}
    	}
    	return res;
    }
}
