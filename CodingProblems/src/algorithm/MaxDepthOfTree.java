package algorithm;

public class MaxDepthOfTree {
	
	public int maxDepth(TreeNode root) {
		return helper(root, 0);
	}
	
	private int helper(TreeNode node, int depth) {
		if (node == null)
			return depth;
		
		int leftDepth = helper(node.left, depth + 1);
		int rightDepth = helper(node.right, depth + 1);
		
		return Math.max(leftDepth, rightDepth);
	}
}
