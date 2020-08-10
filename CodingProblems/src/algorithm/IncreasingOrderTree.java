package algorithm;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		
		IncreasingOrderTree incTree = new IncreasingOrderTree();
		incTree.increasingBST(root);
		
	}
	
	// Given a BST, rearrange the tree in in-order 
	// so that the leftmost node in the tree is now the root of the tree,
	// and every node has no left child and only 1 right child
    public TreeNode increasingBST(TreeNode root) {
     
    	List<Integer> numList = new ArrayList<>();
    	TreeNode newNode;
    	
    	retrieveNum(root, numList);
    	newNode = buildNewTree(numList, 0, null);
    	
    	return newNode;
    }
    
    private void retrieveNum(TreeNode node, List<Integer> list) {
    	
    	if (node == null)
    		return;
    	
    	retrieveNum(node.left, list);
    	list.add(node.val);
    	retrieveNum(node.right, list);
    }

    private TreeNode buildNewTree(List<Integer> list, int idx, TreeNode currentNode) {

    	if (idx < list.size()) {
    		currentNode = new TreeNode(list.get(idx));
    		currentNode.right = buildNewTree(list, idx + 1, currentNode.right);
    	}
		return currentNode;
    }
}
