package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> pathList = new ArrayList<>();
        
        helper(root, "", pathList);
        
    	return pathList;
    }
    
    private void helper(TreeNode node, String path, List<String> list) {
    	StringBuilder sb = new StringBuilder(path);
    	
    	if (node.left == null && node.right == null) {
    		sb.append(node.val);
    		list.add(sb.toString());
    		return;
    	}
    	
    	sb.append(node.val);
    	
    	if (node.left != null) {
    		sb.append("->");
    		helper(node.left, sb.toString(), list);
    	}
    	
    	if (node.right != null) {
    		if (node.left == null)
    			sb.append("->");
    		helper(node.right, sb.toString(), list);
    	}
    }
}













