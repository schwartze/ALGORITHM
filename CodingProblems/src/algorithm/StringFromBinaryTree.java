package algorithm;

public class StringFromBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		// root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(4);
		
		
		StringFromBinaryTree bTree = new StringFromBinaryTree();
		String result = bTree.tree2Str(root);
		System.out.println(result);
	}
	
    public String tree2Str(TreeNode t) {
    	StringBuilder sb = new StringBuilder();
    	constructStr(t, sb);
    	return sb.toString();
    }
    
    private void constructStr(TreeNode node, StringBuilder sb) {
    	sb.append(node.val);
    	
    	if (node.left != null) {
    		sb.append("(");
    		constructStr(node.left, sb);
    		sb.append(")");
    	}
    	
    	if (node.left == null && node.right != null)
    		sb.append("()");
    	
    	if (node.right != null) {
    		sb.append("(");
    		constructStr(node.right, sb);
    		sb.append(")");
    	}
    }
}
