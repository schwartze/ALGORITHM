package algorithm;

public class BSTSearch {

    public TreeNode searchBST(TreeNode root, int val) {
    	if (root == null)
    		return null;
    	
    	if (root.val == val)
    		return root;
    	
    	TreeNode node = null;
    	node = searchBST(root.left, val);
    	if (node == null)
    		node = searchBST(root.right, val);
    	
    	return node;
    }
}
