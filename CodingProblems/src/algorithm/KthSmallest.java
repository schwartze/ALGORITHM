package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthSmallest {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		int res = kthSmallest(root, 3);
		System.out.println(res);
	}
	
    public static int kthSmallest(TreeNode root, int k) {
    	List<Integer> list = new ArrayList<>();
    	helper(root, list);
    	Collections.sort(list);
    	return list.get(k - 1);
    }
    
    private static void helper(TreeNode node, List<Integer> list) {
    	if (node == null)
    		return;
    	
    	list.add(node.val);
    	helper(node.left, list);
    	helper(node.right, list);
    }
}
