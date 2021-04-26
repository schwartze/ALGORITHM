package algorithm;

public class InsertBST {
	
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        
        boolean inserted = helper(root, val);
    	
        if (!inserted) {
    		insertAsLastNode(root.right, val);
    	}
        
    	return root;
    }
    
    private void insertAsLastNode(TreeNode node, int val) {
    	if (node == null) return;
    	
    	if (node.left == null && node.right == null) {
    		node.right = new TreeNode(val);
    		return;
    	}
    	insertAsLastNode(node.right, val);
    }
    
    private boolean helper(TreeNode node, int val) {
        if (node == null)
    		return false;
    	
    	if (node.val > val && node.left == null) {
    		node.left = new TreeNode(val);
    		return true;
    	}
    		
    	return helper(node.left, val) || helper(node.right, val);
    }
    
}
