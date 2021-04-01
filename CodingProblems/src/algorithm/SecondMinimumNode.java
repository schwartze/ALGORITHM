package algorithm;

import java.util.Stack;

public class SecondMinimumNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2147483647);
//		root.right.left = new TreeNode(5);
//		root.right.right = new TreeNode(7);
//		
//		TreeNode node = new TreeNode(2);
//		node.left = new TreeNode(2);
//		node.right = new TreeNode(5);
//		node.left.left = new TreeNode(5);
//		node.right.right = new TreeNode(7);
		
		
		SecondMinimumNode secondMin = new SecondMinimumNode();
		int n = secondMin.findSecondMinimumValue(root);
		System.out.println(n);
	}
	// [2,2,2147483647]
	// [2,2,2]
	// [2,2,5,null,null,5,7]
    long min = Long.MAX_VALUE;
    long secondMin = Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
    	helper(root);
    	return (int) (secondMin == Long.MAX_VALUE ? -1 : secondMin);
    }
    
    private void helper(TreeNode node) {
    	if (node == null)
    		return;
    	
    	if (node.val < min) {
    		secondMin = min;
    		min = node.val;
    	} else if (node.val > min && node.val < secondMin) {
    		secondMin = node.val;
    	}
    	helper(node.left);
    	helper(node.right);
    }
}
