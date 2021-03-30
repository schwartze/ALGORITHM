package algorithm;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.right = new TreeNode(2);
		
		root2.left.left = new TreeNode(3);
		root2.left.right = new TreeNode(3);
		
		root2.left.left.left = new TreeNode(4);
		root2.left.left.right = new TreeNode(4);
		
		System.out.println(isBalanced(root2));
	}
	
    public static boolean isBalanced(TreeNode root) {
    	int depth = findDepth(root, 0);
    	
    	return depth >= 0;
    }
    // a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
    private static int findDepth(TreeNode node, int depth) {
    	if (node == null)
    		return depth;
    	
    	int left = findDepth(node.left, depth + 1);
    	int right = findDepth(node.right, depth + 1);
    	
    	if (left == -1 || right == -1)
    		return -1;
    	
    	return Math.abs(left - right) > 1 ? -1 : Math.max(left, right);
    }
}
