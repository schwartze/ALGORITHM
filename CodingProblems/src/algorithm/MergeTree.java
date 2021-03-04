package algorithm;

public class MergeTree {

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(3);
		
		TreeNode t2 = new TreeNode(1);
		t2.right = new TreeNode(2);
		t2.right.right = new TreeNode(3);
		
		MergeTree mTree = new MergeTree();
		mTree.mergeTrees(t1, t2);
	}
    
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    	TreeNode root = null;
    	
    	if (t1 == null && t2 == null)
    		return root;

    	if (t1 != null && t2 != null)
    		root = merge(t1, t2);
    	
    	if (t1 == null)
    		root = new TreeNode(t2.val);
    	
    	if (t2 == null)
    		root = new TreeNode(t1.val);
    	
    	return root;
    }
    
    private TreeNode merge(TreeNode t1, TreeNode t2) {
    	int sum = t1.val + t2.val;
    	TreeNode newNode = null, left = null, right = null;
    	
    	if (t1.left != null && t2.left != null)
    		left = merge(t1.left, t2.left);
    	
    	if (t1.right != null && t2.right != null)
    		right = merge(t1.right, t2.right);
    	
    	
    	if (t1.left != null && t2.left == null) {
    		left = t1.left;
    	} else if (t2.left != null && t1.left == null) {
    		left = t2.left;
    	}
    	
    	if (t1.right != null && t2.right == null) {
    		right = t1.right;
    	} else if (t2.right != null && t1.right == null) {
    		right = t2.right;
    	}
    	
    	newNode = new TreeNode(sum, left, right);
    	return newNode;
    }
}
