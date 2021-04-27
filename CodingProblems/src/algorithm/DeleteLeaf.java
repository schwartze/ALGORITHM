package algorithm;

public class DeleteLeaf {
	
	public TreeNode deleteLeafOfBST(TreeNode root, int target) {
		boolean hasRoot = helper(root, target);
		
		return hasRoot ? null : root;
	}
	
	private boolean helper(TreeNode node, int value) {
		if (node == null) return false;
		
		boolean hasLeft = helper(node.left, value);
		boolean hasRight = helper(node.right, value);
		
		if (hasLeft)
			node.left = null;
		
		if (hasRight)
			node.right = null;
		
		if (node.val == value && node.left == null && node.right == null)
			return true;

		return false;
	}

}
