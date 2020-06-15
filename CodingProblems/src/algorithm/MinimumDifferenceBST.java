package algorithm;

public class MinimumDifferenceBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(-1);
		root.left.right = new TreeNode(3);
		
		MinimumDifferenceBST minDiff = new MinimumDifferenceBST();
		minDiff.minDiffInBST2(root);
		System.out.println(minDiff.min);
	}
	
	static int diff = Integer.MAX_VALUE;
	
    public int minDiffInBST(TreeNode root) {
     
    	if (root == null)
    		return 0;
    	
    	int left = minDiffInBST(root.left);
    	diff = Math.min(diff, Math.abs(left - root.val));
    	int right = minDiffInBST(root.right);
    	diff = Math.min(diff, Math.abs(right - root.val));
    	
    	return root.val;
    }
    
    int min = Integer.MAX_VALUE,  prev = 0;
    
    public int minDiffInBST2(TreeNode root) {
        
    	if (root.left != null)
    		minDiffInBST2(root.left);
    	
    	if (prev != 0)
    		min = Math.min(min,  root.val - prev);
    	 
    	prev = root.val;
    	
    	if (root.right != null)
    		minDiffInBST2(root.right);
    	
    	return min;
    }
    
}
