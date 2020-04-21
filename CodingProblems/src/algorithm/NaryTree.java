package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTree {

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
		
		NaryTree naryTree = new NaryTree();
		List<Integer> list = naryTree.preorder(root);
		
		for (int n : list)
			System.out.print(n + ", ");
	}
	
	// #1: recursive solution
	public List<Integer> preorderTreverse(Node node) {
		
		List<Integer> result = new ArrayList<>();
		
		if (node == null)
			return result;
		
		helper(node, result);
		
		return result;
	}

	private void helper(Node node, List<Integer> list) {
		
		if (node == null)
			return;

		list.add(node.val);

		if (node.children == null)
			return;
		
		for (Node n : node.children)
			helper(n, list);
	}
	
	
	// #2: iterative solution
	public List<Integer> preorder(Node node) {
		
		List<Integer> result = new ArrayList<>();
		if (node == null)
			return result;
		
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			result.add(temp.val);
			
			if (temp.children != null) {
				
				for (int i = temp.children.size() - 1; i >= 0; i--) {
					stack.push(temp.children.get(i));
				}
			}
		}
		return result;
	}	
}
