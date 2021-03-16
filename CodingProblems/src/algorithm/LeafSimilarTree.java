package algorithm;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTree {
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	List<Integer> list1 = new ArrayList<>();
    	List<Integer> list2 = new ArrayList<>();
    	
    	helper(root1, list1);
    	helper(root2, list2);
    	
    	return list1.equals(list2);
    }
    
    private void helper(TreeNode node, List<Integer> valueList) {
    	if (node.left == null && node.right == null) {
    		valueList.add(node.val);
    		return;
    	}
    	if (node.left != null)
    		helper(node.left, valueList);
    	if (node.right != null)
    		helper(node.right, valueList);
    }
}
