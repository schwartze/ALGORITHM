package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertBST {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		InsertBST insertBST = new InsertBST();
		TreeNode result = insertBST.insertIntoBST(root, 5);
		System.out.println(result.val);
	}

    public TreeNode insertIntoBST(TreeNode root, int val) {
    	List<TreeNode> valList = new ArrayList<>();
    	valList.add(new TreeNode(val));

    	getTreeNodeValues(valList, root);
    	Collections.sort(valList, (a, b) -> a.val - b.val);

    	return buildTree(valList, 0, valList.size() - 1);
    }
    
    private void getTreeNodeValues(List<TreeNode> list, TreeNode node) {
    	if (node == null)
    		return;
    	
    	getTreeNodeValues(list, node.left);
    	list.add(node);
    	getTreeNodeValues(list, node.right);
    }
    
    private TreeNode buildTree(List<TreeNode> list, int min, int max) {
    	if (min > max)
    		return null;

    	int mid = (max - min) / 2 + min; 
    	TreeNode root = list.get(mid);

    	TreeNode left = buildTree(list, min, mid - 1); 
    	TreeNode right = buildTree(list, mid + 1, max);
    	root.left = left;
    	root.right = right;
    	
    	return root;
    }
}
