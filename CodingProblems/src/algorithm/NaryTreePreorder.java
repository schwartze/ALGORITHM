package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NaryTreePreorder {
	
	public static void main(String[] args) {
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		List<Node> depth3 = Arrays.asList(node5, node6);
		
		Node node3 = new Node(3);
		node3.children = depth3;
		Node node2 = new Node(2);
		Node node4 = new Node(4);
		
		List<Node> depth2 = Arrays.asList(node3, node2, node4);
		Node root = new Node(1);
		root.children = depth2;
		
		NaryTreePreorder naryTree = new NaryTreePreorder();
		List<Integer> result = naryTree.preorder(root);
		result.forEach(System.out::print);
	}
	
	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		result.add(root.val);
		helper(result, root);
		return result;
	}
	
	private void helper(List<Integer> list, Node node) {
		if (node == null)
			return;

		if (node.children != null) {

			for (Node child : node.children) {
				list.add(child.val);
				helper(list, child);
			}
		}
		
	}
}
