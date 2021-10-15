package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BalanceBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(17);
		
		root.right.left.left = new TreeNode(7);
		root.right.left.left.left = new TreeNode(2);
		root.right.left.left.right = new TreeNode(12);
		
		root.right.left.left.left.right = new TreeNode(3);
		root.right.left.left.right.left = new TreeNode(9);
		root.right.left.left.right.left.right = new TreeNode(11);
		
		BalanceBST bBST = new BalanceBST();
		bBST.balanceBST(root);
	}
	
	public TreeNode balanceBST(TreeNode root) {
		List<TreeNode> nodeList = new ArrayList<>();
		traverseTree(root, nodeList);
		return buildTree(0, nodeList.size() - 1, nodeList);
    }
	
	private void traverseTree(TreeNode node, List<TreeNode> nodeList) {
		if (node == null)
			return;
		
		traverseTree(node.left, nodeList);
		nodeList.add(node);
		traverseTree(node.right, nodeList);
	}
	
	private TreeNode buildTree(int start, int end, List<TreeNode> nodeList) {
		if (start > end)
			return null;
		
		int mid = (start + end) / 2;
		TreeNode root = nodeList.get(mid);
		
		TreeNode left = buildTree(start, mid - 1, nodeList);
		TreeNode right = buildTree(mid + 1, end, nodeList);
		root.left = left;
		root.right = right;
		
		return root;
	}
}
