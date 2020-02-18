package algorithm;

public class PathSum_3 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		
		root.right.right = new TreeNode(11);
		
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		
		getPath(root, 8);
		
		System.out.println(pathCount);
	}
	
	static int pathCount;
	
	public static void getPath(TreeNode root, int num) {
		
		if (root == null)
			return;
		
		helper(root.left, 0, num);
		helper(root.right, 0, num);
	}
	
	private static void helper(TreeNode node, int sum, int num) {
		
		if (node == null)
			return;
		
		sum += node.val;
		
		helper(node.left, sum, num);
		helper(node.right, sum, num);
		
		if (sum == num)
			pathCount++;
	}
}
