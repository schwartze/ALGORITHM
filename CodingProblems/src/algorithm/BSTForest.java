package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BSTForest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int[] to_delete = {3, 5};
		BSTForest forest = new BSTForest();
		forest.delNodes(root, to_delete);
	}
	
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	List<TreeNode> result = new ArrayList<>();
    	Set<Integer> targetSet = new HashSet<>();
    	
    	for (int num : to_delete)
    		targetSet.add(num);

    	helper(root, targetSet, result);
    	result.add(root);
    	return result;
    }
    
    private boolean helper(TreeNode node, Set<Integer> target, List<TreeNode> list) {
    	if (node == null)
    		return false;
    	
    	if (target.contains(node.val)) {
    		list.add(node);
    		return true;
    	}
    	
    	boolean isLeft = helper(node.left, target, list);
    	boolean isRight = helper(node.right, target, list);
    	
    	if (isLeft) {
    		node.left = null;
    	}
    	
    	if (isRight) {
    		node.right = null;
    	}
    	return false;
    }
}
