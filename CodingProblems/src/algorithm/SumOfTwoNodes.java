package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SumOfTwoNodes {

	// #1. Ssing helper class with a list 
	public boolean findTarget(TreeNode root, int target) {
		
		if (root == null)
			return false;
		
		List<Integer> list = new ArrayList<>();
		
		helper(root, list);
		
		for (int i = 0; i < list.size(); i++) {
			
			for (int j = i + 1; j < list.size(); j++) {
				
				if (list.get(i) + list.get(j) == target)
					return true;
			}
		}
		
		return false;
	}
	
	private void helper(TreeNode node, List<Integer> list) {
		
		if (node == null)
			return;
		
		list.add(node.val);
		helper(node.left, list);
		helper(node.right, list);
	}
	
	// #2. With a list but using while instead of nested for statement
	public boolean findTarget2(TreeNode node, int target) {
		
		if (node == null)
			return false;
		
		List<Integer> list = new ArrayList<>();
		
		helper(node, list);
		
		int l = 0, r = list.size() - 1;
		
		while (r > l) {
			
			int sum = list.get(r) + list.get(l);
			
			if (sum == target)
				return false;
			
			if (sum > target)
				r--;
			else 
				l++;
		}
		
		return false;
	}
	
	// #3. Using set 
	public boolean findTarget3(TreeNode root, int k) {
		
		if (root == null)
			return false;
		
		HashSet<Integer> set = new HashSet<>();
		
		return find(root, k, set);
	}
	
	private boolean find(TreeNode node, int k, HashSet<Integer> set) {
		
		if (node == null)
			return false;
		
		if (set.contains(k - node.val))
			return true;
		
		set.add(node.val);
		
		return find(node.left, k, set) || find(node.right, k, set);
	}
}
