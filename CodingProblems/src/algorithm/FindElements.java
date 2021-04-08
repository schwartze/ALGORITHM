package algorithm;

public class FindElements {

	/*
	 Given a binary tree with the following rules:
	 root.val == 0
	 If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
	 If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
	 Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.
		
	 You need to first recover the binary tree and then implement the FindElements class:
		
	 FindElements(TreeNode* root) Initializes the object with a contamined binary tree, you need to recover it first.
	 bool find(int target) Return if the target value exists in the recovered binary tree.
	 */
	
	TreeNode recoveredRoot = null;
	
    public FindElements(TreeNode root) {
    	root.val = 0;
    	recoverTree(root);
    	recoveredRoot = root;
    }
    
    private void recoverTree(TreeNode node) {
    	if (node == null)
    		return;
    	
    	if (node.left != null)
    		node.left.val = 2 * node.val + 1;
    	
    	if (node.right != null)
    		node.right.val = 2 * node.val + 2;
    	
    	recoverTree(node.left);
    	recoverTree(node.right);
    }
    
    public boolean find(int target) {
    	
    	return findTarget(recoveredRoot, target);
    }
    
    private boolean findTarget(TreeNode node, int target) {
    	if (node == null)
    		return false;
    	
    	if (node.val == target)
    		return true;
    	
    	return findTarget(node.left, target) && findTarget(node.right, target);
    }
}
