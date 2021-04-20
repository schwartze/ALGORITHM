package algorithm;

public class PreorderBST {

	public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
    	
    	for (int i = 1; i < preorder.length; i++) {
    		traverseTree(root, preorder[i]);
    	}
    	
    	return root;
    }
    
    private void traverseTree(TreeNode node, int val) {
    	if (node.val < val) {
    		if (node.right == null) {
        		node.right = new TreeNode(val);
        		return;
    		}
    		traverseTree(node.right, val);
    	}
    	
    	if (node.val > val) {
    		if (node.left == null) {
        		node.left = new TreeNode(val);
        		return;
    		}
    		traverseTree(node.left, val);
    	}
    }
}
