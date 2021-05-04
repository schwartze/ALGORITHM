package algorithm;

public class BinaryTreePruning {

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(1);
//		
//		root.left.left = new TreeNode(0);
//		root.left.right = new TreeNode(0);
//		
//		root.right.left = new TreeNode(0);
//		root.right.right = new TreeNode(1);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.left.left.left = new TreeNode(0);
		
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(1);
		
		TreeNode root2 = new TreeNode(1);
		root2.right = new TreeNode(0);
		root2.right.left = new TreeNode(0);
		root2.right.right = new TreeNode(1);
		
		TreeNode root3 = new TreeNode(0);
		root3.right = new TreeNode(0);
		root3.right.left = new TreeNode(0);
		root3.right.right = new TreeNode(0);
		
		TreeNode res = pruneTree(root3);
		System.out.println(res);
		
	}
	
    public static TreeNode pruneTree(TreeNode root) {
    	if (root == null)
    		return null;
    	
    	boolean rootPruned = isTarget(root);
    	
    	return rootPruned ? null : root;
    }
    
    private static boolean isTarget(TreeNode node) {
    	if (node == null)
    		return false;
    	
    	boolean leftPruned = isTarget(node.left);
    	boolean rightPruned = isTarget(node.right);

    	if (leftPruned)
    		node.left = null;
    	
    	if (rightPruned)
    		node.right = null;

    	return node.left == null && node.right == null && node.val == 0;
    }
}
