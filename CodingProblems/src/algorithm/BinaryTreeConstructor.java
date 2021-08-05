package algorithm;

public class BinaryTreeConstructor {

	int preIndex = 0, postIndex = 0;
	
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    	TreeNode node = new TreeNode(preorder[preIndex++]);
    	
    	if (node.val != postorder[postIndex]) 
    		node.left = constructFromPrePost(preorder, postorder);
    	
    	if (node.val != postorder[postIndex]) 
    		node.right = constructFromPrePost(preorder, postorder);
    	
    	postIndex++;
    	return node;
    }
    
}
