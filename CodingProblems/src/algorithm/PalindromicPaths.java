package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromicPaths {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(3);
		
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(1);
		root2.right.right = new TreeNode(1);
		root2.right.left = new TreeNode(3);
		root2.right.left.left = new TreeNode(1);
		
		int res = pseudoPalindromicPaths(root2);
		System.out.println(res);
	}

    public static int pseudoPalindromicPaths (TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	findAllPaths(list, new ArrayList<>(), root);
    	int count = 0;
    	
    	for (List<Integer> path : list)
    		if (isPalindrome(path))
    			count++;
    	
    	return count;
    }
    
    private static boolean findAllPaths(List<List<Integer>> list, List<Integer> path, TreeNode node) {
    	if (node == null)
    		return true;

    	path.add(node.val);
    	boolean leftFlag = findAllPaths(list, new ArrayList<>(path), node.left);
    	boolean rightFlag = findAllPaths(list, new ArrayList<>(path), node.right);
    	
    	if (leftFlag && rightFlag)
    		list.add(path);
    	
    	return false;
    }
    
    private static boolean isPalindrome(List<Integer> path) {
    	Set<Integer> set = new HashSet<>();
    	
    	for (int n : path) {
    		if (set.contains(n))
    			set.remove(n);
    		else 
    			set.add(n);
    	}
    	
    	return set.size() <= 1;
    }
}
