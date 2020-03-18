package algorithm;

import java.util.HashMap;
import java.util.Map;

public class FindModeOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		
		FindModeOfTree mode = new FindModeOfTree();
		int result = mode.getMode(root);
		System.out.println(result);
	}
	
	public int getMode(TreeNode root) {
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(root.val, 1);
		
		scanNode(root.left, map);
		scanNode(root.right, map);
		
		int max = Integer.MIN_VALUE;
		
		for (Map.Entry<Integer, Integer> m: map.entrySet()) {
			
			if (m.getValue() > max)
				max = m.getValue();
		}
			
		return map.get(max);
	}
	
	private void scanNode(TreeNode node, HashMap<Integer, Integer> map) {
		
		if (node == null)
			return;
		
		int count = map.getOrDefault(node.val, 0);
		map.put(node.val, ++count);
		
		scanNode(node.left, map);
		scanNode(node.right, map);
	}
}
