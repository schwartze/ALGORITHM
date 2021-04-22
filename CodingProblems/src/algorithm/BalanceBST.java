package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BalanceBST {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> valueList = new ArrayList<>();
    	getAllValues(root, valueList);
    	Collections.sort(valueList);
    	
    	int mid = valueList.size() / 2;
    	TreeNode newNode = new TreeNode(valueList.get(mid));
    	buildBalancedBST(newNode, valueList, true, mid - 1);
    	buildBalancedBST(newNode, valueList, false, mid + 1);
    	
    	return newNode;
    }
    private void buildBalancedBST(TreeNode node, List<Integer> list, boolean isLeft, int idx) {
    	if (idx < 0 || idx >= list.size())
    		return;
    	TreeNode temp = null;

    	if (node.val > list.get(idx)) {
    		temp = new TreeNode(list.get(idx));
    		node.left = temp;
    		idx--;
    		buildBalancedBST(temp, list, isLeft, idx);
    	} else {
    		temp = new TreeNode(list.get(idx));
    		node.right = temp;
    		idx++;
    		buildBalancedBST(temp, list, isLeft, idx);
    	}
    }
    
    private void getAllValues(TreeNode node, List<Integer> list) {
    	if (node == null)
    		return;
    	
    	list.add(node.val);
    	getAllValues(node.left, list);
    	getAllValues(node.right, list);
    }
}
