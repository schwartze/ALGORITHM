package algorithm;

import java.util.Stack;

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
	
	// A greater tree is that every value of each node is changed 
	// to the original key plus sum of all keys greater than
	// the original key in the tree
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

	// iterative method
	public TreeNode convertTree(TreeNode root) {
		int sum = 0;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while (!stack.isEmpty() || node != null) {
			
			while (node != null) {
				stack.push(node);
				node = node.right;
			}
			
			node = stack.pop();
			sum += node.val;
			node.val = sum;
			
			node = node.left;
		}
		
		return root;
	}
	
}
