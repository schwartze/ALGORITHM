package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalanceBST {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(14);
		root.right.right = new TreeNode(17);
		
		root.right.left.left = new TreeNode(7);
		root.right.left.left.left = new TreeNode(2);
		root.right.left.left.right = new TreeNode(12);
		
		root.right.left.left.left.right = new TreeNode(3);
		root.right.left.left.right.left = new TreeNode(9);
		root.right.left.left.right.left.right = new TreeNode(11);
		
		BalanceBST bBST = new BalanceBST();
		bBST.balanceBST(root);
	}
	
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();
    	getAllValues(root, valueList);
    	Collections.sort(valueList);
    	
    	int mid = valueList.size() / 2 - 1;
    	TreeNode newNode = new TreeNode(valueList.get(mid));
    	buildBalancedBST(newNode, valueList, 0, mid);
    	buildBalancedBST(newNode, valueList, mid, valueList.size());
    	
    	return newNode;
    }
    
    private void buildBalancedBST(TreeNode node, List<Integer> list, int l, int r) {
    	if (l >= r || node == null || r == 0)
    		return;
    	
    	int mid = l == 0 ? ((r - l) / 2) : ((r - l) / 2 + l);
    	if (list.get(mid) < 0)
    		return;
    	TreeNode temp = null;
    	if (node.val > list.get(mid)) {
    		temp = new TreeNode(list.get(mid));
    		node.left = temp;
    	} else {
    		temp = new TreeNode(list.get(mid));
    		node.right = temp;
    	}
    	list.set(mid, -1);
		buildBalancedBST(temp, list, l, mid);
		buildBalancedBST(temp, list, mid, r);
    }
    
    private void getAllValues(TreeNode node, List<Integer> list) {
    	if (node == null)
    		return;
    	
    	list.add(node.val);
    	getAllValues(node.left, list);
    	getAllValues(node.right, list);
    }
}
