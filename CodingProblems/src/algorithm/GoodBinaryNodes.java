package algorithm;

public class GoodBinaryNodes {

	static int count = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);
		
		TreeNode root2 = new TreeNode(3);
		root2.left = new TreeNode(3);
		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(2);
		
		GoodBinaryNodes gNodes = new GoodBinaryNodes();
		gNodes.goodNodes(root2);
		System.out.println(count);
	}
	
	// Given a binary tree root, a node X in the tree is named good 
	// if in the path from root to X there are no nodes with a value greater than X.
	public int goodNodes(TreeNode root) {
		countGoodNodes(root, root.val);;
		
    	return count;
    }
	
	private void countGoodNodes(TreeNode node, int prevMax) {
		if (node == null)
			return;
			
		if (node.val >= prevMax) {
			count++;
			prevMax = node.val;
		}
		
		countGoodNodes(node.left, prevMax);
		countGoodNodes(node.right, prevMax);
	}
}
