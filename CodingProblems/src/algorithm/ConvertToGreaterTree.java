package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertToGreaterTree {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(13);
		ConvertToGreaterTree converter = new ConvertToGreaterTree();
		converter.toGreaterTree(root);
		
		System.out.println(root.left.val);
		System.out.println(root.val);
		System.out.println(root.right.val);
	}
	
	public TreeNode toGreaterTree(TreeNode root) {

		if (root == null)
			return null;
		
		helper(root);
		
		return root;
	}
	
	private int sum = 0;
	
	private void helper(TreeNode node) {
		
		if (node == null)
			return;

		helper(node.right);
		sum += node.val;
		node.val = sum;
		helper(node.left);
	}
}
