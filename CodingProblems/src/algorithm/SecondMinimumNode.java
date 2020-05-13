package algorithm;

import java.util.Stack;

public class SecondMinimumNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(2);
		node.right = new TreeNode(5);
//		node.left.left = new TreeNode(5);
//		node.right.right = new TreeNode(7);
		
		
		SecondMinimumNode secondMin = new SecondMinimumNode();
		int n = secondMin.findSecondMinimumValue(node);
		System.out.println(n);
	}
	// [2,2,2147483647]
	// [2,2,2]
	// [2,2,5,null,null,5,7]
    public int findSecondMinimumValue(TreeNode root) {
    	// nums[0] : min
    	// nums[1] : secondMin
    	int[] nums = {root.val, (int) Long.MAX_VALUE};
    	
    	helper(root, nums);
    	
    	return nums[1] < Long.MAX_VALUE ? nums[1] : -1;
    }
    
    private void helper(TreeNode node, int[] nums) {
    	
    	if (node == null)
    		return;
    	
    	helper(node.left, nums);
    	if (node.val < nums[1] && node.val > nums[0]) {
    		nums[1] = node.val;
    	}
    	helper(node.right, nums);
    }
    
    
    public int findSecondMinimumValue2(TreeNode root) {
    	
    	int max = root.val;
    	int secondMax = -1;
    	
    	Stack<TreeNode> stack = new Stack<>();
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		TreeNode node = stack.pop();
    		
    		if (node.val > max) {
    			secondMax = max;
    			max = node.val;
    		}
    		
    		if (node.left != null)
    			stack.push(node.left);
    		
    		if (node.right != null)
    			stack.push(node.right);
    	}
    	return secondMax;
    }
}
