package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AvgBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		
		root.left.left= new TreeNode(0);
		root.left.right = new TreeNode(2);
		
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(1);
		
		AvgBinaryTree avgBinaryTree = new AvgBinaryTree();
		List<Double> res = avgBinaryTree.avgOfTreeLevels(root);
		
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
    	
    	int num = 0;
    	
    	num = left == 0 ? num : num + 1;
    	num = right == 0 ? num : num + 1;
    	    	
    	if (left != 0 || right != 0) 
    		avg.add((double)(left + right) / num);
    	
    	return node.val;
    }
    
    public List<Double> avgOfTreeLevels(TreeNode root) {
    	
    	List<Integer> count = new ArrayList<>();
    	List<Double> res = new ArrayList<>();
    	
    	avg(root, 0, res, count);
    	
    	for (int i = 0; i < res.size(); i++) {
    		res.set(i, res.get(i) / count.get(i));
    	}
    	
    	return res;
    }
    
    private void avg(TreeNode node, int i, List<Double> sum, List<Integer> count) {
    	
    	if (node == null)
    		return;
    	
    	if (i < sum.size()) {
    		sum.set(i, sum.get(i) + node.val);
    		count.set(i, count.get(i) + 1);
    	} else {
    		sum.add(1.0 * node.val);
    		count.add(1);
    	}
    	
    	avg(node.left, i + 1, sum, count);
    	avg(node.right, i + 1, sum, count);
    }
}
