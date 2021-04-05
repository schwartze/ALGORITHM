package algorithm;

public class MinDepth {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		TreeNode root2 = new TreeNode(2);
		root2.right = new TreeNode(3);
		root2.right.right = new TreeNode(4);
		root2.right.right.right = new TreeNode(5);
		root2.right.right.right.right = new TreeNode(6);
		
		
		int min = minDepth(root2);
		System.out.println(min);
	}
	// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    public static int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
    	return helper(root, 0, Integer.MAX_VALUE);
    }
    
    private static int helper(TreeNode node, int depth, int minDepth) {
    	if (node.left == null && node.right == null)
    		return Math.min(depth + 1, minDepth);

    	int leftMinDepth = Integer.MAX_VALUE, rightMinDepth = Integer.MAX_VALUE;
    	
    	if (node.left != null)
    		leftMinDepth = helper(node.left, depth + 1, minDepth);
    	
    	if (node.right != null)
    		rightMinDepth = helper(node.right, depth + 1, minDepth);
    	
		return Math.min(leftMinDepth, rightMinDepth);
    }
}
