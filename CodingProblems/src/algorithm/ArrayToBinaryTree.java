package algorithm;

import java.util.Arrays;

public class ArrayToBinaryTree {

	public static void main(String[] args) {
		int[] nums = {-10, -3, 0, 5, 9};
		
		TreeNode tNode = sortedArrayToBST(nums);
	}

    public static TreeNode sortedArrayToBST(int[] nums) {
    	if (nums.length <= 0)
    		return null;
    	
    	int min = 0;
    	int max = nums.length;
    	int mid = (max - min) / 2;
    	
    	int[] left = Arrays.copyOfRange(nums, min, mid);
    	int[] right = Arrays.copyOfRange(nums, mid + 1, max);
    	
    	TreeNode root = new TreeNode(nums[mid]);
    	TreeNode leftNode = sortedArrayToBST(left);
    	TreeNode rightNode = sortedArrayToBST(right);
    	
    	root.left = leftNode;
    	root.right = rightNode;
    	return root;
    }
}
