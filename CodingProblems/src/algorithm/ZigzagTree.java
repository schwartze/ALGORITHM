package algorithm;

import java.util.LinkedList;
import java.util.List;

public class ZigzagTree {
	
	public static void main(String[] args) {
		int label = 14;
		
		List<Integer> res = pathInZigZagTree(label);
		
		for (int n : res)
			System.out.print(n + ", ");
	}

	public static List<Integer> pathInZigZagTree(int label) {
		LinkedList<Integer> res = new LinkedList<>();
		int parent = label;
		res.addFirst(parent);
		
		while (parent > 1) {
			int depth = (int)(Math.log(parent) / Math.log(2));
			int offset = (int)(Math.pow(2, depth + 1) - 1 - parent);
			parent = ((int)Math.pow(2, depth) + offset) / 2;
			res.addFirst(parent);
		}
		
    	return res;
    }
}
