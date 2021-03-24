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
    
    public boolean isCousins(TreeNode root, int x, int y) {
    	int[] xArr = new int[2];
    	int[] yArr = new int[2];
    	
    	helper(root, x, xArr, 0);
    	helper(root, y, yArr, 0);
    	
    	return xArr[0] != yArr[0] && xArr[1] == yArr[1];
    }
    
    private void helper(TreeNode node, int value, int[] arr, int depth) {
    	if (node == null)
    		return;
    	
    	if (node.left != null && node.left.val == value) {
    		arr[0] = node.val;
    		arr[1] = depth + 1;
    		return;
    	}
    	
    	if (node.right != null && node.right.val == value) {
    		arr[0] = node.val;
    		arr[1] = depth + 1;
    		return;
    	}
    	helper(node.left, value, arr, depth + 1);
    	helper(node.right, value, arr, depth + 1);
    }
}
