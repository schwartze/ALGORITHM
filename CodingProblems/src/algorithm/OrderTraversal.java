package algorithm;

import java.util.ArrayList;
import java.util.List;

public class OrderTraversal {
	
	public static void main(String[] args) {
		Node n14 = new Node(14);
		List<Node> depth4_1 = new ArrayList<>();
		depth4_1.add(n14);
		
		Node n11 = new Node(11, depth4_1);
		Node n12 = new Node(12);
		Node n13 = new Node(13);
		
		List<Node> depth3_1 = new ArrayList<>();
		depth3_1.add(n11);
		
		List<Node> depth3_2 = new ArrayList<>();
		depth3_2.add(n12);

		List<Node> depth3_3 = new ArrayList<>();
		depth3_3.add(n13);
		
		Node n6 = new Node(6);
		Node n7 = new Node(7, depth3_1);
		Node n8 = new Node(8, depth3_2);
		Node n9 = new Node(9, depth3_3);
		Node n10 = new Node(10);
		
		List<Node> depth2_1 = new ArrayList<>();
		depth2_1.add(n6);
		depth2_1.add(n7);
		
		List<Node> depth2_2 = new ArrayList<>();
		depth2_1.add(n8);
		
		List<Node> depth2_3 = new ArrayList<>();
		depth2_1.add(n9);
		depth2_1.add(n10);
		
		Node n2 = new Node(2);
		Node n3 = new Node(3, depth2_1);
		Node n4 = new Node(4, depth2_2);
		Node n5 = new Node(5, depth2_3);
		
		List<Node> depth1 = new ArrayList<>();
		depth1.add(n2);
		depth1.add(n3);
		depth1.add(n4);
		depth1.add(n5);
		Node root = new Node(1, depth1);
		
		List<List<Integer>> result = levelOrder(root);
		
		for (List<Integer> list : result) {
			for (int n : list) 
				System.out.print(n + ", ");
			System.out.println();
		}
	}
    
	public static List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> rootList = new ArrayList<>();
		rootList.add(root.val);
		result.add(rootList);
		helper(result, root, 1);
    	return result;
    }
	
	private static void helper(List<List<Integer>> result, Node node, int level) {
		List<Node> children = node.children;
		if (children == null)
			return;
		
		for (Node n : children) {
			List<Integer> list = null;

			if (result.size() > level) {
				list = result.get(level);
				list.add(n.val);
			} else {
				list = new ArrayList<>();
				list.add(n.val);
				result.add(list);
			}
			helper(result, n, level + 1);
		}
	}
}
