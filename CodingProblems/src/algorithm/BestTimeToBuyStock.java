package algorithm;

public class BestTimeToBuyStock {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int[] prices2 = {7,6,4,3,1};
		int[] prices3 = {2,4,1};
		
		int profit = maxProfit(prices2);
		System.out.println(profit);
	}
	
    public static int maxProfit(int[] prices) {
    	int max = 0, min = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < prices.length; i++) {
    		
    		if (prices[i] < min)
    			min = prices[i];
    		else if (prices[i] > min)
    			max = Math.max(max, prices[i] - min);
    	}
    	
    	return 0;
    }
}
