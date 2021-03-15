package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(4);
		tree.left = new TreeNode(7);
		tree.left.left = new TreeNode(9);
		tree.left.right = new TreeNode(6);
		
		tree.right = new TreeNode(2);
		tree.right.left = new TreeNode(3);
		tree.right.right = new TreeNode(1);
		
		TreeNode newHead = invertTree(tree);
		
	}
    public static TreeNode invertTree(TreeNode root) {
    	if (root == null)
    		return null;
    	
    	TreeNode left = invertTree(root.left);
    	TreeNode right = invertTree(root.right);
    	
    	root.left = right;
    	root.right = left;
    	
    	return root;
    }
}
