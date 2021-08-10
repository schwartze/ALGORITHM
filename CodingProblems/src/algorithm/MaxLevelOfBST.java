package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxLevelOfBST {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(0);
		
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);

		TreeNode root2 = new TreeNode(989);
		root2.right = new TreeNode(10250);
		root2.right.left = new TreeNode(98693);
		root2.right.right = new TreeNode(-89388);
		root2.right.right.right = new TreeNode(-32127);
		
		TreeNode root3 = new TreeNode(-100);
		root3.left = new TreeNode(-200);
		root3.right = new TreeNode(-300);
		root3.left.left = new TreeNode(-20);
		root3.left.right = new TreeNode(-5);
		root3.right.left = new TreeNode(-10);
		
		MaxLevelOfBST maxLevel = new MaxLevelOfBST();
		int res = maxLevel.maxLevelSum(root3);
		System.out.println(res);
	}

    public int maxLevelSum(TreeNode root) {
    	List<Integer> nodeSumList = new ArrayList<>();
    	getMaxSumLevel(root, 1, nodeSumList);
    	
    	int maxLevel = 0, max = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < nodeSumList.size(); i++) {
    		if (nodeSumList.get(i) > max) {
    			max = nodeSumList.get(i);
    			maxLevel = i + 1;
    		}
    	}
    	
    	return maxLevel;
    }
    
    private void getMaxSumLevel(TreeNode node, int level, List<Integer> list) {
    	if (node == null)
    		return;
    	
    	if (list.size() >= level) {
    		int numInSameLevel = list.get(level - 1);
    		list.add(level - 1, numInSameLevel + node.val);
    		list.remove(level);
    	} else {
    		list.add(node.val);
    	}
    	
    	getMaxSumLevel(node.left, level + 1, list);
    	getMaxSumLevel(node.right, level + 1, list);
    }
}
