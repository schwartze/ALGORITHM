package algorithm;

public class RangeSumOfBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		
		root.left.left = new TreeNode(3);
		root.left.left = new TreeNode(1);

		root.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(6);
		
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(18);
		int L = 6, R = 10;
		
		RangeSumOfBST rsBST = new RangeSumOfBST();
		int res = rsBST.rangeSumBST(root, L, R);
		System.out.println(res);
	}
	
	// Return the sum of values of all nodes with value between L and R (inclusive)
    public int rangeSumBST(TreeNode root, int L, int R) {
    	int[] res = new int[1];
    	
    	helper(root, L, R, res);
    	
    	return res[0];
    }
    
    private int[] helper(TreeNode node, int L, int R, int[] sum) {
    	
    	if (node == null)
    		return null;
    	
    	helper(node.left, L, R, sum);
    	if (node.val >= L && node.val <= R)
    		sum[0] += node.val;
    	helper(node.right, L, R, sum);
    	
    	return sum;
    }
}
