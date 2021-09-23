package algorithm;

public class BottomLeftTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(4);
		root2.right = new TreeNode(3);
		root2.right.left = new TreeNode(5);
		root2.right.right = new TreeNode(6);
		root2.right.left.left = new TreeNode(7);
		
		BottomLeftTree bottomLeftTree = new BottomLeftTree();
		int res = bottomLeftTree.findBottomLeftValue(root2);
		System.out.println(res);
	}
	
    public int findBottomLeftValue(TreeNode root) {
    	helper(root, false, 0);
    	
    	return val;
    }
    
    int level = 0;
    int val = 0;
    
    private void helper(TreeNode node, boolean isLeft, int lvl) {
    	if (node == null)
    		return;
    	
    	if (isLeft && lvl > level) {
    		level = lvl;
    		val = node.val;
    	}
    	
    	helper(node.left, true, lvl + 1);
    	helper(node.right, false, lvl + 1);
    }
}
