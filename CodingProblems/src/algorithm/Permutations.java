package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		
		Permutations permutations = new Permutations();
		List<List<Integer>> res = permutations.permute(nums);
		
		for (List<Integer> lists : res) {
			for (int n : lists)
				System.out.print(n + ", ");
			System.out.println();
		}
	}
    
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		backtrack(result, list, nums);
		return result;
    }
	
	private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i]))
				continue;
			list.add(nums[i]);
			backtrack(result, list, nums);
			list.remove(list.size() - 1);
		}
	}
}
