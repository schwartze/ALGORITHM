package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SumOfTwoNodes {

	
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
}
