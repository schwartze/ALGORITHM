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
		int result = diameter.diameterOfBinaryTree(root);
		System.out.println(result);
		
	}
    int maxDepth = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
    	helper(root);
    	return maxDepth;
    }
    
    private void helper(TreeNode node) {
    	if (node == null)
    		return;
    	
    	int leftMaxDepth = getDepth(node.left, 0);
    	int rightMaxDepth = getDepth(node.right, 0);
    	maxDepth = Math.max(maxDepth, leftMaxDepth + rightMaxDepth);
    	
    	helper(node.left);
    	helper(node.right);
    }
    
    private int getDepth(TreeNode node, int depth) {
    	if (node == null)
    		return depth;
    	return Math.max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1));
    }
}
