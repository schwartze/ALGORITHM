package algorithm;

public class DeepestNode {

	int maxDepth = 0;
	int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) {
    	helper(root, 0);
    	
    	return sum;
    }
    
    private void helper(TreeNode node, int depth) {
    	if (node == null)
    		return;
    	
    	if (node.left == null && node.right == null) {
    		if (depth > maxDepth) {
    			maxDepth = depth;
    			sum = node.val;
    		} else if (depth == maxDepth)
    			sum += node.val;
    		return;
    	}
    	
    	helper(node.left, depth + 1);
    	helper(node.right, depth + 1);
    }
}
