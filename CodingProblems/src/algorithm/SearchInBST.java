package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SearchInBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		
		SearchInBST search = new SearchInBST();
		search.searchBST(root, 2);
	}
	
    public TreeNode searchBST(TreeNode root, int val) {
     
    	// 1. traverse all nodes and find if value of any node is equal to given integer val
    	// 2. store value of the node and any of its sub nodes
    	List<Integer> list = new ArrayList<>();
    	findVal(root, val, list);

    	// 3. construct a new tree
    	if (!list.contains(val))
    		return null;

    	List<Integer> subList = list.subList(list.get(val), list.size());
    	TreeNode newNode = buildTree(subList, new TreeNode(), 0);
    	
    	return newNode;
    }
    
    private TreeNode buildTree(List<Integer> subList, TreeNode node, int i) {

    	if (i < subList.size()) {
    		TreeNode temp = new TreeNode(subList.get(i));
    		node = temp;

    		node.right = buildTree(subList, node.right, i + 1);
    		node.left = buildTree(subList, node.left, i + 2);
    	}
    	
    	return node;
    }
    
    private void findVal(TreeNode node, int val, List<Integer> list) {
    	
    	if (node == null)
    		return;
    	
    	list.add(node.val);
    	
    	findVal(node.right, val, list);
    	findVal(node.left, val, list);
    }
}
