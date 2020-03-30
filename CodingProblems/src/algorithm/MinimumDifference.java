package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumDifference {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		
		MinimumDifference mindifference = new MinimumDifference();
		int result = mindifference.getMinDifference(root);
		System.out.println(result);
	}
	
	// method to find the minimum absolute difference
	// between values of any two nodes
	public int getMinDifference(TreeNode root) {
		
		List<Integer> nodeValueList = new ArrayList<>();
		saveNodeValue(root, nodeValueList);
		
		int minDiff = Integer.MAX_VALUE;		
		
		for (int i = 0; i < nodeValueList.size(); i++) {
			
			for (int j = i + 1; j < nodeValueList.size() - 1; j++) {

				int diff = nodeValueList.get(i) - nodeValueList.get(j);
				
				if (Math.abs(diff) < minDiff)
					minDiff = Math.abs(diff);
			}
		}
		return minDiff;
	}
	
	private void saveNodeValue(TreeNode node, List<Integer> set) {
		
		if (node == null)
			return;
		
		saveNodeValue(node.left, set);
		saveNodeValue(node.right, set);

		set.add(node.val);
	}
}
