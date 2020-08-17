package algorithm;

import java.util.HashSet;
import java.util.Set;

public class UnivaluedTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		
		root.right.right = new TreeNode(1);
		
		UnivaluedTree uniTree = new UnivaluedTree();
		boolean res = uniTree.isUnivalTree(root);
		System.out.println(res);
	}
	
    public boolean isUnivalTree(TreeNode root) {
     
    	Set<Integer> set = new HashSet<>();
    	
    	helper(root, set);
    	
    	return set.size() == 1;
    }
    
    private void helper(TreeNode node, Set<Integer> set) {
    	
    	if (node == null)
    		return;
    	
    	helper(node.left, set);
    	set.add(node.val);
    	helper(node.right, set);
    }
}
