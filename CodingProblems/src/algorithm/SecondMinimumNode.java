package algorithm;

public class SecondMinimumNode {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(2);
		node.right = new TreeNode(5);
		
		
		SecondMinimumNode secondMin = new SecondMinimumNode();
		int n = secondMin.findSecondMinimumValue(node);
		System.out.println(n);
	}
	
    public int findSecondMinimumValue(TreeNode root) {
    	// nums[0] : max
    	// nums[1] : secondMax
    	int[] nums = {-1, -1};
    	
    	helper(root, nums);
    	
    	return nums[1];
    }
    
    private void helper(TreeNode node, int[] nums) {
    	
    	if (node == null)
    		return;
    	
    	helper(node.left, nums);
    	if (node.val > nums[0]) {
    		nums[1] = nums[0];
    		nums[0] = node.val;
    	}
    	helper(node.right, nums);
    }
}
