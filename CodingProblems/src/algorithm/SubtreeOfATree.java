package algorithm;

public class SubtreeOfATree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(2);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(2);
		
		TreeNode root3 = new TreeNode(1);
		root3.left = new TreeNode(1);
		
		TreeNode root4 = new TreeNode(1);
		
		SubtreeOfATree subtree = new SubtreeOfATree();
		boolean result = subtree.isSubtree(root3, root4);
		System.out.println(result);
	}
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if (s == null)
    		return false;
    	
    	boolean result = false;
		if (s.val == t.val) {
    		result = helper(s, t);
    	}
		
    	return result || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean helper(TreeNode s, TreeNode t) {
    	if (s == null && t == null)
    		return true;
    	
    	if (s == null || t == null)
    		return false;
    	
    	if (s.val != t.val)
    		return false;
    	
    	return helper(s.left, t.left) && helper(s.right, t.right);
    }
    
}
