package algorithm;

public class DeepestNodes {

    TreeNode deepest;
    int deepestLevel = 0;
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
    	DeepestNodes dNodes = new DeepestNodes();
		TreeNode deepestNode = dNodes.subtreeWithAllDeepest(root);
		System.out.println(deepestNode.val);
	}
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	helper(root, 0);
    	return deepest;
    }
    
    private int helper(TreeNode node, int level) {
    	if (node.left == null && node.right == null) {
    		return level; 
    	}
    
    	int leftLevel = 0, rightLevel = 0;
    	if (node.left != null)
    		leftLevel = helper(node.left, level + 1);
    	if (node.right != null)
    		rightLevel = helper(node.right, level + 1);
    	
    	if (leftLevel == rightLevel && leftLevel > deepestLevel) {
    		deepestLevel = leftLevel;
    		deepest = node;
    	} else if (leftLevel > deepestLevel) {
    		deepest = node.left;
    		deepestLevel = leftLevel;
    	} else if (rightLevel > deepestLevel) {
    		deepest = node.right;
    		deepestLevel = rightLevel;
    	}
    	return level;
    }
}
