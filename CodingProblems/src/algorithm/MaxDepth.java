package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MaxDepth {

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
		
		
		// make another tree
		Node one = new Node(1);
		List<Node> oneChildren = new ArrayList<>();
		one.children = oneChildren;
		
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		oneChildren.add(two);
		oneChildren.add(three);
		oneChildren.add(four);
		oneChildren.add(five);
		
		List<Node> threeChildren = new ArrayList<>();
		List<Node> fourChildren = new ArrayList<>();
		List<Node> fiveChildren = new ArrayList<>();
		three.children = threeChildren;
		four.children = fourChildren;
		five.children = fiveChildren;
		
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		
		threeChildren.add(six);
		threeChildren.add(seven);
		
		fourChildren.add(eight);
		
		fiveChildren.add(nine);
		fiveChildren.add(ten);
		
		Node eleven = new Node(10);
		Node twelve = new Node(10);
		Node thirteen = new Node(10);
		
		List<Node> sevenChildren = new ArrayList<>();
		List<Node> eightChildren = new ArrayList<>();
		List<Node> nineChildren = new ArrayList<>();
		
		seven.children = sevenChildren;
		eight.children = eightChildren;
		nine.children = nineChildren;
		
		sevenChildren.add(eleven);
		
		eightChildren.add(twelve);
		
		nineChildren.add(thirteen);
		
		Node fourteen = new Node(14);
		
		List<Node> elevenChildren = new ArrayList<>();
		eleven.children = elevenChildren;
		
		elevenChildren.add(fourteen);
		
		MaxDepth maxDepth = new MaxDepth();
		int result = maxDepth.getMaxDepth(one);
		System.out.println(result);
		
	}
	
	public int getMaxDepth(Node root) {
		
		if (root == null)
			return 0;
		
		int depth = 1;
		helper(root, depth);
		
		return max;
	}
	
	int max = Integer.MIN_VALUE;
	
	private int helper(Node node, int depth) {
		
		if (node == null || node.children == null) {
			if (depth > max)
				max = depth;
			return 0;
		}

		depth++;
		
		for (Node n : node.children) {

			helper(n, depth);
		}
		
		return depth;
	}
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}