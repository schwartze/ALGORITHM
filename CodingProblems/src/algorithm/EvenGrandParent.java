package algorithm;

public class EvenGrandParent {

    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
    	helper(root);
    	return sum;
    }
    
    private void helper(TreeNode node) {
    	if (node == null)
    		return;
    	
    	if (node.val % 2 == 0 && node.left != null) {
    		sum += node.left.left == null ? 0 : node.left.left.val;
    		sum += node.left.right == null ? 0 : node.left.right.val;
    	}

    	if (node.val % 2 == 0 && node.right != null) {
    		sum += node.right.left == null ? 0 : node.right.left.val;
    		sum += node.right.right == null ? 0 : node.right.right.val;
    	}

		helper(node.left);
		helper(node.right);
   }
}
