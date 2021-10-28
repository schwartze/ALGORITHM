package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class CircularGame {
	
	public static void main(String[] args) {
		int n = 5, k = 2;
		
		int res = findTheWinner(n, k);
		System.out.println(res);
	}

    public static int findTheWinner(int n, int k) {
    	Queue<Integer> queue = new LinkedList<>();
    	for (int i = 1; i <= n; i++)
    		queue.add(i);
    	
    	while (queue.size() > 1) {
    		int cnt = 0;
    		
    		while (cnt++ < k - 1) {
    			queue.add(queue.poll());
    		}
    		queue.poll();
    	}
    	return queue.poll();
    }
}
