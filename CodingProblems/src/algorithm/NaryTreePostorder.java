package algorithm;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorder {

	public static void main(String[] args) {
		// make a tree
		Node root = new Node(1);
		root.children = new ArrayList<>();
		Node left = new Node(3);
		root.children.add(left);
		root.children.add(new Node(2));
		root.children.add(new Node(4));
		
		left.children = new ArrayList<>();
		left.children.add(new Node(5));
		left.children.add(new Node(6));
		
		NaryTreePostorder naryTree = new NaryTreePostorder();
		List<Integer> list = naryTree.postorder(root);

		for (int n : list)
			System.out.print(n + ", ");
	}
	
	public List<Integer> postorder(Node node) {
		List<Integer> result = new ArrayList<>();
		
		helper(node, result);
		result.add(node.val);
		
		return result;
	}
	
	private void helper(Node node, List<Integer> list) {
		
		if (node == null)
			return;
		
		if (node.children == null)
			return;
		
		for (Node n : node.children) {
			helper(n, list);
			list.add(n.val);
		}
	}
}
