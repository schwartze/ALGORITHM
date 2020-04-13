package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTilt {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		BinaryTreeTilt bTreeTilt = new BinaryTreeTilt();
		int result = bTreeTilt.findTile(root);
		System.out.println(result);
		
	}
	// find sum of the difference between left and right nodes for each tree node
	public int findTile(TreeNode root) {
		
		if (root == null)
			return 0;
		
		Queue<Integer> queue = new LinkedList<>();
		
		helper(root, queue);
		
		int sum = 0;
		
		while (!queue.isEmpty()) {
			sum += queue.poll();
		}
		
		return sum;
	}
	
	private int helper(TreeNode node, Queue<Integer> queue) {
		
		if (node == null)
			return 0;
		
		int left = helper(node.left, queue);
		int right = helper(node.right, queue);
		
		queue.add(Math.abs(left - right));
		
		return node.val;
	}
}
