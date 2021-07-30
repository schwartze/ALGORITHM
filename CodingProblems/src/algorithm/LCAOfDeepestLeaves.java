package algorithm;

public class LCAOfDeepestLeaves {
	
	int maxDepth = 0;
	TreeNode lca = null;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		
		root.right = new TreeNode(3);
		
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(5);
		root1.left.left = new TreeNode(6);
		root1.left.right = new TreeNode(2);
		root1.left.right.left = new TreeNode(7);
		root1.left.right.right = new TreeNode(4);
		
		root1.right = new TreeNode(1);
		root1.right.left = new TreeNode(0);
		root1.right.right = new TreeNode(8);
		
		
		LCAOfDeepestLeaves lcaOfDeepestLeaves = new LCAOfDeepestLeaves();
		TreeNode lcaRoot = lcaOfDeepestLeaves.lcaDeepestLeaves(root1);
		System.out.println(lcaRoot.val);
	}
	
	
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		lca = root;
		helper(root, 0);
		return lca;
    }
	
	private int helper(TreeNode node, int depth) {
		if (node.left == null && node.right == null) 
			return depth;
		
		int leftDepth = 0, rightDepth = 0;
		
		if (node.left != null)
			leftDepth = helper(node.left, depth + 1);
		
		if (node.right != null)
			rightDepth = helper(node.right, depth + 1);
		
		if (leftDepth == 0 && rightDepth == 0 && node.left != null && node.right != null) {
			leftDepth = helper(node.left, depth + 1);
			rightDepth = helper(node.right, depth + 1);
		}
		
		if (leftDepth >= rightDepth && leftDepth > maxDepth) {
			maxDepth = depth;
			lca = node.left;
		} else {
			maxDepth = depth;
			lca = node.right;
		}
		
		return depth;
	}
}
