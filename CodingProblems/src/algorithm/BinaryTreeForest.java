package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTreeForest {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		root.right= new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		int[] to_delete = {3, 5};
		List<TreeNode> list = delNodes(root, to_delete);
		
		for (TreeNode node : list)
			System.out.print(node.val + ", ");
		
	}
	
    public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    	List<TreeNode> list = new ArrayList<>();
    	Set<Integer> set = new HashSet<>();
    	
    	for (int n : to_delete)
    		set.add(n);
    	
    	helper(list, set, root, true);
    	return list;
    }
    
    private static TreeNode helper(List<TreeNode> list, Set<Integer> set, TreeNode node, boolean isRoot) {
    	if (node == null)
    		return null;
    	
    	boolean isTarget = set.contains(node.val);
    	if (isRoot && !isTarget)
    		list.add(node);
    	
    	node.left = helper(list, set, node.left, isTarget);
    	node.right = helper(list, set, node.right, isTarget);
    	
    	return isTarget ? null : node;
    }
}
