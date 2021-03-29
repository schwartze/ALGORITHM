package algorithm;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		
		// root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		
		// root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		
		boolean res = isSymmetric(root);
		System.out.println(res);
		
	}
	
    public static boolean isSymmetric(TreeNode root) {
        
    	return helper(root.left, root.right);
    }
    
    private static boolean helper(TreeNode node1, TreeNode node2) {
    	if (node1 == null && node2 == null)
    		return true;
    	
    	// can be checked with or operation
    	// one of the nodes is not null if code reaches here 
    	if (node1 == null || node2 == null)
    		return false;
    	
    	if (node1.val != node2.val)
    		return false;

    	return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}

