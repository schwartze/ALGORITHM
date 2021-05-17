package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DifferenceBtwNodeAndAncestor {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(0);
		root.right.right.left = new TreeNode(3);
		
		TreeNode root2 = new TreeNode(8);
		root2.left = new TreeNode(3);
		root2.left.left = new TreeNode(1);
		root2.left.right = new TreeNode(6);
		root2.left.right.left = new TreeNode(4);
		root2.left.right.right = new TreeNode(7);
		
		root2.right = new TreeNode(10);
		root2.right.right = new TreeNode(14);
		root2.right.right.left = new TreeNode(13);
		
		DifferenceBtwNodeAndAncestor nodeAndAncestor = new DifferenceBtwNodeAndAncestor();
		int max = nodeAndAncestor.maxAncestorDiff(root2);
		System.out.println(max);
	}
	
    public int maxAncestorDiff(TreeNode root) {
    	List<Integer> valueList = new ArrayList<>();

    	return getMaxDiff(root, valueList, 0);
    }
    
    private int getMaxDiff(TreeNode node, List<Integer> valueList, int max) {
    	if (node == null)
    		return max;
    	
    	int currValue = node.val;
    	
    	for (int i = 0; i < valueList.size(); i++)
    		if (Math.abs(valueList.get(i) - currValue) > max)
    			max = Math.abs(valueList.get(i) - currValue);
    	
    	valueList.add(node.val);
    	int leftMax = getMaxDiff(node.left, valueList, max);
    	int rightMax = getMaxDiff(node.right, valueList, max);
    	
    	return Math.max(leftMax, rightMax);
    }
    
}
