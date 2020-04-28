package algorithm;

public class StringFromBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		
		
		StringFromBinaryTree bTree = new StringFromBinaryTree();
		String result = bTree.treeToString(root);
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
    
    /*
     * 4 cases to take into account 
     * 
     * case 1. when a node has both right and left nodes
     * 
     * case 2. when a node has neither right nor left node 
     * 
     * case 3. when a node has left node only
     * --> need an empty () to represent left node of null
     * 
     * case 4. when a node has right node only 
     */
    
    public String treeToString(TreeNode t) {
    	
    	if (t == null)
    		return "";
    	
    	if (t.right == null && t.left == null)
    		return t.val + "";

    	// Thus, when t.left != null, 
    	// process of checking right node is omitted 
    	// no need to have an additional () for empty right node
    	if (t.right == null)
    		return "(" + treeToString(t.left) + ")" + t.val;
    		
    	return t.val + "(" + treeToString(t.left) + ")(" + treeToString(t.right) + ")";
    }
    
}
