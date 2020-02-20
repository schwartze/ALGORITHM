package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumbersNotInArr {

	public static void main(String[] args) {
		int[] arr = {4,3,2,7,8,2,3,1};

		List<Integer> result = getNumsNotInArr(arr);

		for (int n : result)
			System.out.println(n);
		
	}
	
	public static List<Integer> getNumsNotInArr(int[] nums) {
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			
			if (nums[val] > 0)
				nums[val] = -nums[val];
		}
		
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] > 0)
				result.add(i + 1);
		}
		
		return result;
	}
}
