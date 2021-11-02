package algorithm;

public class MinimumDifferenceBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(-1);
		root.left.right = new TreeNode(3);
		
		MinimumDifferenceBST minDiff = new MinimumDifferenceBST();
		int res = minDiff.minDiffInBST(root);
		System.out.println(res);
	}
	
	boolean init = false;
	int min = Integer.MAX_VALUE;
	int prev = 0;
	
	public int minDiffInBST(TreeNode root) {
		inorder(root);
		return min;
	}
	
	private void inorder(TreeNode node) {
		if (node == null)
			return;
		
		inorder(node.left);
		if (!init) {
			init = true; 
		}
		else {
			min = Math.min(min, node.val - prev);
		}
		inorder(node.right);
	}
}
