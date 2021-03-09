package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {

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
		List<Integer> res = postorder(root);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static List<Integer> postorder(Node root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null)
    		return list;
    	
    	helper(root, list);
    	list.add(root.val);
    	return list;
    }
    
    private static void helper(Node node, List<Integer> list) {
    	if (node == null || node.children == null)
    		return;
    	
    	List<Node> childrenList = node.children;
    	for (Node child : childrenList) {
    		helper(child, list);
    		list.add(child.val);
    	}
    }
    
    public static List<Integer> iterative(Node root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null)
    		return list;
    	
    	Stack<Node> stack = new Stack<>();
    	stack.push(root);
    	
    	while (!stack.isEmpty()) {
    		root = stack.pop();
    		list.add(root.val);
    		
    		for (Node child : root.children) 
    			stack.add(child);
    	}
    	Collections.reverse(list);
    	return list;
    }
}
