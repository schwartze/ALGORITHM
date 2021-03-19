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

	
	public int findTilt(TreeNode root) {
		int[] sum = new int[1];
		helper(root, sum);
		return sum[0];
	}
	
	private int helper(TreeNode node, int[] sum) {
		if (node == null)
			return 0;
		
		int leftValue = helper(node.left, sum);
		int rightValue = helper(node.right, sum);
		
		sum[0] += Math.abs(leftValue - rightValue);
		
		return leftValue + rightValue + node.val;
	}
}
