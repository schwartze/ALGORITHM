package algorithm;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(6);
		
		
		DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
		int result = diameter.getDiameterOfTree(root);
		System.out.println(result);
		
	}
	int max = 0;
	int count = 0;
	
	public void helper(TreeNode root) {
		
		if (root == null)
			return;
		
		if (root.left != null && root.right != null)
			count--;
		count++;
		helper(root.left);
		helper(root.right);
	}
	
	
	public int getDiameterOfTree(TreeNode root) {
		
		maxDepth(root);
		
		return max;
	}
	
	private int maxDepth(TreeNode node) {
		
		if (node == null)
			return 0;
		
		int left = maxDepth(node.left);
		int right = maxDepth(node.right);
			
		max = Math.max(max, left + right);
		
		return Math.max(left, right) + 1;
	}

}
