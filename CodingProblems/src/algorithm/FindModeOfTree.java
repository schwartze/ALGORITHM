package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(2);
		
		
		FindModeOfTree mode = new FindModeOfTree();
		int[] result = mode.findMode(root);
		System.out.println(result);
	}
	
    public int[] findMode(TreeNode root) {
    	Map<Integer, Integer> nodeMap = new HashMap<>();
    	helper(root, nodeMap);

    	int max = 0;
    	for (int count : nodeMap.values()) 
    		if (count >= max) 
    			max = count;
    	
    	List<Integer> list = new ArrayList<>();
    	
    	for (int key : nodeMap.keySet())
    		if (nodeMap.get(key) == max)
    			list.add(key);
    	
    	int[] result = new int[list.size()];
    	
    	for (int i = 0; i < list.size(); i++)
    		result[i] = list.get(i);
    	
    	return result;
    }
    
    private void helper(TreeNode node, Map<Integer, Integer> map) {
    	if (node == null)
    		return;
    	
    	map.put(node.val, map.getOrDefault(node.val, 0) + 1);
    	helper(node.left, map);
    	helper(node.right, map);
    }
}
