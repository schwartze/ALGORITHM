package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCousin {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right= new TreeNode(4);
 		root.right.right= new TreeNode(5);
		
		int x = 5, y = 4;
		BinaryTreeCousin btCousin = new BinaryTreeCousin();
		boolean res = btCousin.isCousins(root, x, y);
		System.out.println(res);
	}
	
	// Returns true if and only if 
	// #1. two nodes are in the same level
	// #2. parent node of two nodes are different (cousin)
    public boolean isCousins(TreeNode root, int x, int y) {
    	Map<Integer, Integer> map = new HashMap<>();

    	map.put(root.val, 0);
    	helper(root, map);

    	hasSameParent(root, x, y);
    	
    	return map.get(x) == map.get(y) && !hasSameParent(root, x, y);
    }
    
    private boolean hasSameParent(TreeNode node, int x, int y) {
    	
    	if (node == null)
    		return false;
    	
    	if (node.left != null && node.right != null) {
    		if ((node.left.val == x && node.right.val == y) || 
    				(node.left.val == y && node.right.val == x))
    			return true;
    	}

    	return hasSameParent(node.left, x, y) || hasSameParent(node.right, x, y);
    }
    
    private void helper(TreeNode node, Map<Integer, Integer> map) {
    	
    	if (node == null)
    		return;
    	
    	if (node.left != null)
    		map.put(node.left.val, map.get(node.val) + 1);

    	if (node.right != null)
    		map.put(node.right.val, map.get(node.val) + 1);

    	helper(node.left, map);
    	helper(node.right, map);
    }
}
