package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
	
	public static void main(String[] args) {
		int[] nums = {1, 1, 2};
		int[] nums2 = {1, 2, 3};
		
		List<List<Integer>> result = permuteUnique(nums2);
		
		for (List<Integer> list : result) {
			for (int n : list) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
	}
	
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        
        
        
        
    	return result;
    }
    
    private static void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int idx) {
    	if (list.size() == nums.length) {
    		if (!result.contains(list)) {
        		result.add(new ArrayList<>(list));
    		}
    		return;
    	}
    	
    	for (int i = 0; i < nums.length; i++) {
    		if (i == idx) continue;
    		list.add(nums[i]);
    		dfs(result, list, nums, i);
    		list.remove(list.size() - 1);
    	}
    	
    }

}
