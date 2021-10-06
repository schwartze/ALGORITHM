package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		int target = 7;
		
		combinationSum(candidates, target).stream()
				.collect(Collectors.toList())
				.stream().collect(Collectors.toList()).forEach(System.out::print);
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	helper(result, new ArrayList<Integer>(), 0, candidates, target);
    	
    	return result;
    }
    
    private static void helper(List<List<Integer>> result, List<Integer> list, int idx, int[] candidates, int target) {
    	if (target < 0) {
    		return;
    	} else if (target == 0) {
    		result.add(new ArrayList<>(list));
    		return;
    	} else {
        	for (int i = idx; i < candidates.length; i++) {
        		list.add(candidates[i]);
        		helper(result, list, i, candidates, target - candidates[i]);
        		list.remove(list.size() - 1);
        	}
    	}
    }
}
