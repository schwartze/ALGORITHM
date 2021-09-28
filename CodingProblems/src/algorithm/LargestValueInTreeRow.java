package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LargestValueInTreeRow {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(3);
		
		root.right.right = new TreeNode(9);
		
		largestValues(root).stream()
						   .collect(Collectors.toList())
						   .forEach(System.out::print);;
		
	}
	
    public static List<Integer> largestValues(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	helper(list, root, 0);
    	return list;
    }
    
    private static void helper(List<Integer> list, TreeNode node, int level) {
    	if (node == null)
    		return;
    	
    	if (list.size() == level) {
    		list.add(node.val);
    	} else {
    		list.add(level, Math.max(list.get(level), node.val));
    		list.remove(level + 1);
    	}
    	
    	helper(list, node.left, level + 1);
    	helper(list, node.right, level + 1);
    }
}
