package algorithm;

public class StringFromBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(4);
		
		
		StringFromBinaryTree bTree = new StringFromBinaryTree();
		String result = bTree.tree2str(root);
		System.out.println(result);
	}
	
    public String tree2str(TreeNode t) {
        
    	StringBuffer sb = new StringBuffer();
    	
    	helper(t, sb);
    	
    	return sb.toString().replace("()", "");
    }
    
    private void helper(TreeNode node, StringBuffer sb) {
    	
    	if (node == null) 
    		return;
    	
    	sb.append(node.val + "(");
    	helper(node.left, sb);
    	sb.append(")(");
    	helper(node.right, sb);
    	sb.append(")");
    }
}
