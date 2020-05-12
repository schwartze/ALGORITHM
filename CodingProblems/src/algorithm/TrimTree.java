package algorithm;

import java.util.ArrayList;
import java.util.List;

public class TrimTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(0);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(1);
		
		TrimTree trim = new TrimTree();
		TreeNode result = trim.trimBST(root, 1, 3);
		System.out.println(result);
		
	
	}
	
	public TreeNode trimBST(TreeNode root, int L, int R) {
		
		if (root == null)
			return root;
		
		if (root.val > R)
			return trimBST(root.left, L, R);
		
		if (root.val < L)
			return trimBST(root.right, L, R);
		
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		
		return root;
	}

}
