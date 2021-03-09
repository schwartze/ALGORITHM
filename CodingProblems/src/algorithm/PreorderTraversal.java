package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

	public static void main(String[] args) {
		Node c5 = new Node(5);
		Node c6 = new Node(6);
		
		List<Node> list1 = new ArrayList<>();
		list1.add(c5);
		list1.add(c6);
		
		Node c3 = new Node(3, list1);
		Node c2 = new Node(2);
		Node c4 = new Node(4);
		
		List<Node> list2 = new ArrayList<>();
		list2.add(c3);
		list2.add(c2);
		list2.add(c4);
		
		Node root = new Node(1, list2);
		List<Integer> res = iterative(root);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static List<Integer> preorder(Node root) {
    	List<Integer> list = new ArrayList<>();
    	helper(root, list);
    	return list;
    }
    
    private static void helper(Node node, List<Integer> list) {
    	if (node == null)
    		return;
    	
    	if (node.children == null) {
    		list.add(node.val);
    		return;
    	}
    	
    	list.add(node.val);
    	List<Node> childrenList = node.children;
    	for (Node child : childrenList)
    		helper(child, list);
    }
    
    public static List<Integer> iterative(Node root) {
    	List<Integer> list = new ArrayList<>();
    	Stack<Node> stack = new Stack<>();
    	stack.add(root);
    	
    	while (!stack.isEmpty()) {
    		root = stack.pop();
    		list.add(root.val);
    		
    		if (root.children == null)
    			continue;
    		for (int i = root.children.size() - 1; i >= 0; i--)
    			stack.push(root.children.get(i));
    	}
    	
    	return list;
    }
}
