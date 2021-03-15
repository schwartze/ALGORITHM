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
		
		// [2147483647,2147483647,2147483647]
		TreeNode root2 = new TreeNode(2147483647);
		root2.left = new TreeNode(2147483647);
		root2.right = new TreeNode(2147483647);
		
		AvgBinaryTree avgBinaryTree = new AvgBinaryTree();
		List<Double> res = avgBinaryTree.averageOfLevels(root2);
		
		for (double d : res) {
			System.out.print(d + ", ");
		}
	}
	
    public List<Double> averageOfLevels(TreeNode root) {
    	List<Double> res = new ArrayList<>();
    	List<Double> countList = new ArrayList<>();
    	List<Double> sumList = new ArrayList<>();
    	
    	helper(root, countList, sumList, 0);
    	
    	for (int i = 0; i < countList.size(); i++) 
    		res.add(sumList.get(i) / countList.get(i));
    	
    	return res;
    }
    
    private void helper(TreeNode node, List<Double> countList, List<Double> sumList, int depth) {
    	if (node == null)
    		return;
    	
    	if (countList.size() <= depth) {
    		countList.add(1.0);
    		sumList.add(node.val * 1.0);
    	} else {
    		countList.set(depth, countList.get(depth) + 1);
    		sumList.set(depth, sumList.get(depth) + node.val);
    	}
    	
    	helper(node.left, countList, sumList, depth + 1);
    	helper(node.right, countList, sumList, depth + 1);
    }
}
