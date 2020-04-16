package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SubtreeOfATree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(4);
		root1.right = new TreeNode(5);
		root1.left.left = new TreeNode(1);
		root1.left.right = new TreeNode(2);
		
		TreeNode root2 = new TreeNode(4);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(5);
		
		SubtreeOfATree subtree = new SubtreeOfATree();
		boolean result = subtree.isSubtree(root1, root2);
		System.out.println(result);
	}
	
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	
    	List<Integer> list1 = new ArrayList<>();
    	List<Integer> list2 = new ArrayList<>();
    	
    	scanTree(s, list1);
    	scanTree(t, list2);

    	List<Integer> temp = list1.subList(list1.indexOf(list2.get(0)), list2.size() + 1);
    	
    	for (int i = 0; i < temp.size(); i++) {
    		if (temp.get(i) != list2.get(i))
    			return false;
    	}
    	
    	return true;
    }

	private void scanTree(TreeNode s, List<Integer> list) {
		
		if (s == null)
			return;
		
		list.add(s.val);
		
		scanTree(s.left, list);
		scanTree(s.right, list);
	}

}
