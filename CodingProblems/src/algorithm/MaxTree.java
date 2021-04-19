package algorithm;

public class MaxTree {
	
	public static void main(String[] args) {
		MaxTree mTree = new MaxTree();
		int[] nums = {3,2,1,6,0,5};
		TreeNode root = mTree.constructMaximumBinaryTree(nums);
		System.out.println(root.val);
	}

	/*
	 * A Max tree has following characteristics:  
	 * 1. It has a root node whose value is the maximum value in nums.
	 * 2. It's left node is built on the subarray prefix to the left of the maximum value.
	 * 3. It's left node is built on the subarray suffix to the right of the maximum value.
	 */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	return buildMaxTree(nums, 0, nums.length);
    }
    
    private TreeNode buildMaxTree(int[] nums, int l, int r) {
    	if (l == r)
    		return null;
    	
    	int maxIdx = getIdxOfMaxValue(nums, l, r);
    	TreeNode node = new TreeNode(nums[maxIdx]);
    	
    	TreeNode left = buildMaxTree(nums, l, maxIdx);
    	TreeNode right = buildMaxTree(nums, maxIdx + 1, r);
    	
    	node.left = left;
    	node.right = right;
    	
    	return node;
    }
    
    private int getIdxOfMaxValue(int[] arr, int l, int r) {
    	int idx = l;
    	
    	while (l < r) {
    		if (arr[l] > arr[idx]) {
    			idx = l;
    		}
    		l++;
    	}
    	
    	return idx;
    }
}
