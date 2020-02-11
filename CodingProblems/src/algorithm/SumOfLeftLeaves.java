package algorithm;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		
		System.out.println(getSum(root));
		
	}
	
	public static int getSum(TreeNode root) {
		
		if (root == null)
			return 0;
	
		int sum = 0;
		
		if (root.left != null) {
			
			if (root.left.left == null && root.left.right == null)
				sum += root.left.val;
			else 
				sum += getSum(root.left);
		}
		sum += getSum(root.right);
		
		return sum;
	}
}
