package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStone {

	public static void main(String[] args) {
		int[] stones = {2, 7, 4, 1, 8, 1};
		LastStone stone = new LastStone();
		int res = stone.lastStoneWeight(stones);
		System.out.println(res);
	}
	
	// choose two heaviest stones and smash them together until only 1 stone is left 
    public int lastStoneWeight(int[] stones) {
    	Queue<Integer> pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
    	
    	for (int n : stones)
    		pq.offer(n);
    	
    	while (pq.size() > 1) {
    		int max = pq.poll();
    		int secondMax = pq.poll();
    		
			pq.offer(max - secondMax);
    	}
    	return pq.poll();
    }
}
