package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		int[] nums2 = {0};
		
		List<List<Integer>> res = subsets(nums2);
		
		for (List<Integer> list : res) {
			for (int n : list)
				System.out.print(n + ", ");
			System.out.println();
		}
	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	helper(result, new ArrayList<>(), 0, nums);
    	return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> list, int idx, int[] nums) {
    	if (!result.contains(list))
    		result.add(new ArrayList<>(list));
		
    	for (int i = idx; i < nums.length; i++) {
    		list.add(nums[i]);
    		helper(result, list, i + 1, nums);
    		list.remove(list.size() - 1);
    	}
    }
}
