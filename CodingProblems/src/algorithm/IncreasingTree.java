package algorithm;

public class IncreasingTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		
		root.right = new TreeNode(6);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		
		TreeNode root2 = new TreeNode(5);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(7);
		
		TreeNode node = increasingBST(root2);
		System.out.println(node.val);
	}
	
    public static TreeNode increasingBST(TreeNode root) {
    	if (root == null)
    		return null;
    	
    	TreeNode left = increasingBST(root.left);
    	TreeNode right = increasingBST(root.right);
    	
    	if (left == null && right == null)
    		return root;
    	
    	TreeNode node = null;
    	if (left == null && right != null) {
    		node = new TreeNode(root.val);
    		node.right = right;
    		return node;
    	}
    	
    	node = left;
    	while (node.right != null) 
    		node = node.right;
    	
    	node.right = new TreeNode(root.val);
    	if (right != null) 
    		node.right.right = right;
    	
    	return left;
    }
}
