package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxDiffAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(8);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(7);
		
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		
		MaxDiffAncestor diffAncestor = new MaxDiffAncestor();
		int res = diffAncestor.maxAncestorDiff(root);
		System.out.println(res);
	}
	
	
    public int maxAncestorDiff(TreeNode root) {
    	List<Integer> nodeValueList = new ArrayList<>();
    	getMaxDiff(root, nodeValueList);
    	getMaxDiff(root, nodeValueList);
    	
    	return max;
    }
    
    int max = 0;
    
    private void getMaxDiff(TreeNode node, List<Integer> ancestorList) {
    	if (node == null)
    		return;
    	
    	for (int value : ancestorList)
    		max = Math.max(max, Math.abs(value - node.val));
    	
    	List<Integer> nodeValueList = new ArrayList<>(ancestorList);
    	nodeValueList.add(node.val);
    	
    	getMaxDiff(node.left, nodeValueList);
    	getMaxDiff(node.right, nodeValueList);
    }
}
