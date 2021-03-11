package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSum {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(1);
		
		int res = getBinarySum(root);
		System.out.println(res);
	}
	
	public static int getBinarySum(TreeNode root) {
		List<Integer> bNumberList = new ArrayList<>();
		int res = 0;
		helper(root, "", bNumberList);
		
		for (int num : bNumberList)
			res += num;
		
		return res;
	}
	
	private static void helper(TreeNode node, String numStr, List<Integer> list) {
		String sum = numStr + Integer.toString(node.val);
		if (node.left == null && node.right == null) {
			list.add(Integer.parseInt(sum, 2));
			return;
		}
		if (node.left != null)
			helper(node.left, sum, list);
		if (node.right != null)
			helper(node.right, sum, list);
	}
}
