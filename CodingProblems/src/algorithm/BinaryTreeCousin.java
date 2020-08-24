package algorithm;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeCousin {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right= new TreeNode(4);
// 		root.right.right= new TreeNode(5);
		
		int x = 2, y = 3;
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
    	boolean hasSameParent = false;
		int xParent = map.get(x) - 1;
		int yParent = map.get(y) - 1;
    	
    	for (int n : map.keySet()) 
    		if (map.get(n) == xParent && map.get(n) == yParent)
    			hasSameParent = true;
    	
    	return !hasSameParent && map.get(x) == map.get(y);
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
