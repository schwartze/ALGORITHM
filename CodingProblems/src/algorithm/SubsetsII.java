package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SubsetsII {

	public static void main(String[] args) {
		SubsetsII subSets = new SubsetsII();
		subSets.subsetsWithDup(new int[] { 1, 2, 2 });
	}
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	dfs(result, new ArrayList<>(), nums, 0);
    	return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int idx) {
    	if (!result.contains(list)) {
        	result.add(new ArrayList<>(list));
    	}
    	
		if (list.size() == nums.length) {
    		return;
    	}
	
		for (int i = idx; i < nums.length; i++) {
    		list.add(nums[i]);
    		dfs(result, list, nums, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}
