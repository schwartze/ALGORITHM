package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubtreeOfATree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(2);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(5);
		
		SubtreeOfATree subtree = new SubtreeOfATree();
		boolean result = subtree.isSubtree(root1, root2);
		System.out.println(result);
	}
	// t is a subtree of s only if they have the same structure and values for nodes 
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	
    	StringBuffer treeS = new StringBuffer();
    	StringBuffer treeT = new StringBuffer();
    	
    	preorder(s, treeS);
    	preorder(t, treeT);

    	return treeS.toString().indexOf(treeT.toString()) >= 0;
    }

	private String preorder(TreeNode node, StringBuffer sb) {
		
		if (node == null)
			return "null ";
		
		sb.append("#" + node.val + " ");
		
		preorder(node.left, sb);
		preorder(node.right, sb);
		
		return sb.toString();
	}

}
