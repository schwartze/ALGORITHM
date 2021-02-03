package algorithm;

import java.util.PriorityQueue;

public class StoneWeight {
    
	public static void main(String[] args) {
		int[] stones = {2,7,4,1,8,1};
		int[] stones2 = {1, 3, 2, 1, 10, 9};
		
		int res = lastStoneWeight(stones2);
		System.out.println(res);
	}
	/*
	 * We have a collection of stones, each stone has a positive integer weight.
	 * Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
	 * If x == y, both stones are totally destroyed;
	 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
	 */
	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		
		for (int stone : stones)
			queue.add(stone);
		
		while (queue.size() > 1) {
			int curr = queue.poll();
			int prev = queue.poll();
			
			if (curr - prev > 0) 
				queue.add(curr - prev);
		}
		
    	return queue.peek() == null ? 0 : queue.poll();
    }

}
