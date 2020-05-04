package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AvgBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		AvgBinaryTree avgBinaryTree = new AvgBinaryTree();
		List<Double> res = avgBinaryTree.averageOfLevels(root);
		
		for (double d : res) {
			System.out.print(d + ", ");
		}
	}
	
    public List<Double> averageOfLevels(TreeNode root) {
     
    	if (root == null)
    		return null;
    	
    	Stack<Double> avgStack = new Stack<>();
    	helper(root, avgStack);

    	List<Double> result = new ArrayList<>();
    	result.add((double) root.val);
    	
    	while (!avgStack.isEmpty()) {
    		result.add(avgStack.pop());
    	}
    	
    	return result;
    }
    
    private int helper(TreeNode node, Stack<Double> avg) {
    	
    	if (node == null)
    		return 0;
    	
    	int left = helper(node.left, avg);
    	int right = helper(node.right, avg);
    	
    	if (left != 0 && right != 0) 
    		avg.add((double)(left + right) / 2);
    	
    	return node.val;
    }
}
