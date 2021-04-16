package algorithm;

public class GreaterSumTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);
		
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		
		GreaterSumTree gst = new GreaterSumTree();
		gst.bstToGst(root);
	}
	
    public TreeNode bstToGst(TreeNode root) {
    	helper(root, 0);
    	return root;
    }
    
    private int helper(TreeNode node, int cummulativeSum) {
    	if (node == null)
    		return cummulativeSum;
    	
    	int right = helper(node.right, cummulativeSum);
    	int left = helper(node.left, right + node.val);
    	node.val = right + node.val;
    	
    	return left;
    }
}
