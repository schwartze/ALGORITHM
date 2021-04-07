package algorithm;

public class CloneOfTree {
	
	public static void main(String[] args) {
		TreeNode original = new TreeNode(1);
		original.left = new TreeNode(2);
		original.right = new TreeNode(3);
		
		original.left.left = new TreeNode(4);
		original.left.right = new TreeNode(5);
		
		original.left.left.left = new TreeNode(8);
		original.left.left.right = new TreeNode(9);
		
		original.left.right.left = new TreeNode(10);
		
		original.right.left = new TreeNode(6);
		original.right.right = new TreeNode(7);
		
		TreeNode cloned = original;
		
		TreeNode result = getTargetCopyWithDupValues(original, cloned, original.left.right);
		System.out.println(result.val);
	}

	// case1: when all values of the nodes are unique
    public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    	return helper(cloned, target);
    }
    
    private static TreeNode helper(TreeNode cloned, TreeNode target) {
    	if (cloned == null)
    		return null;
    	
    	if (cloned.val == target.val)
    		return cloned;
    	
    	TreeNode result = null;
    	result = helper(cloned.left, target);
    	if (result == null)
    		result = helper(cloned.right, target);
    	
    	return result;
    }
    
    // case2: when both original and cloned tree contains repeated values 
    static int originalSequence = 0;
    static int clonedSequence = 0;
    
    public static final TreeNode getTargetCopyWithDupValues(final TreeNode original, final TreeNode cloned, final TreeNode target) {
    	findTargetSeq(original, target);
    	return findTargetInClonedTree(cloned, target);
    }
    
    private static int findTargetSeq(TreeNode original, TreeNode target) {
        if (original == null)
            return 0;
        
    	if (original == target)
    		return originalSequence + 1;
    	
    	originalSequence++;
    	int seq = 0;
    	seq = findTargetSeq(original.left, target);
    	if (seq == 0)
    		seq = findTargetSeq(original.right, target);
    	return seq;
    }
    
    private static TreeNode findTargetInClonedTree(TreeNode cloned, TreeNode target) {
    	if (cloned == null)
    		return null;
    	
    	if (cloned.val == target.val && clonedSequence == originalSequence)
    		return cloned;
    	
    	clonedSequence++;
    	TreeNode result = null;
    	result = helper(cloned.left, target);
    	if (result == null)
    		result = helper(cloned.right, target);
    	
    	return result;
    }
}
