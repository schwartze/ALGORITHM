package algorithm;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(7);
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(1);
		root2.left.right = new TreeNode(2);
		root2.right = new TreeNode(4);
		
		TreeNode p2 = new TreeNode(3);
		TreeNode q2 = new TreeNode(2);
		
		
		TreeNode result = lowestCommonAncestor(root2, p2, q2);
		
		System.out.println(result.val);
	}

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	TreeNode node = null;
    	if (root.val > p.val && root.val > q.val) {
    		node = lowestCommonAncestor(root.left, p, q);
    	}
    	
    	if (root.val < p.val && root.val < q.val) {
    		node = lowestCommonAncestor(root.right, p, q);
    	}
    	
    	if ((p.val < root.val && root.val < q.val) || (q.val < root.val && root.val < p.val)) {
    		return root;
    	}
    	
    	if (root.val == q.val || root.val == p.val)
    		return root;
    	
    	return node;
    }
}
