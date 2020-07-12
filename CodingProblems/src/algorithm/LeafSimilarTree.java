package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {
    
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<TreeNode> listForOne = new ArrayList<>();
		List<TreeNode> listForTwo = new ArrayList<>();
		
		getLeaves(root1, listForOne);
		getLeaves(root2, listForTwo);
		
		for (int i = 0; i < listForOne.size(); i++) 
			if (listForOne.get(i) != listForTwo.get(i))
				return false;

		return true;
    }

	private void getLeaves(TreeNode node, List<TreeNode> leafList) {
		
		if (node.left == null && node.right == null)
			leafList.add(node);
		
		getLeaves(node.left, leafList);
		getLeaves(node.right, leafList);
	}
}
