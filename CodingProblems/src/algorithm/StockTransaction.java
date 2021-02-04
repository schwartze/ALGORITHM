package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class StockTransaction {

	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		int[] prices2 = {1, 2, 3, 4, 5};
		int[] prices3 = {7, 6, 4, 3, 1};
		
		int profit = maxProfit(prices3);
		System.out.println(profit);
	}
	
    public static int maxProfit(int[] prices) {
    	int profit = 0;
    	Queue<Integer> queue = new LinkedList<>();
    	
    	for (int price : prices)
    		queue.add(price);
    	
    	boolean buying = false;
    	int buyPrice = 0;
    	
    	while (!queue.isEmpty()) {
    		int current = queue.poll();
    		
    		if (!buying && (queue.peek() == null || current < queue.peek())) {
    			buying = true;
    			buyPrice = current;
    			continue;
    		}
    		
    		if (buying && (queue.peek() == null || current > queue.peek())) {
    			profit += current - buyPrice; 
    			buying = false;
    		}
    	}
    	return profit;
    }
    
    public int getMaxProfit(int[] prices) {
    	int profit = 0;
    	
    	for (int i = 0; i < prices.length - 1; i++) {
    		if (prices[i + 1] > prices[i]) {
    			profit += prices[i + 1] - prices[i];
    		}
    	}
    	return profit;
    }
}
