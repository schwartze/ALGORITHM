package algorithm;

public class Stock {
	
	public int[] solution(int[] prices) {
    	int len = prices.length;
    	int[] answer = new int[len];
        
        for (int i = 0; i < prices.length; i++) {
        	int j = i + 1;
        	boolean isPriceDropped = false;
        	
        	for (; j < prices.length; j++) {
        		
        		if (prices[j] < prices[i]) {
        			isPriceDropped = true;
        			break;
        		}
        	}
        	answer[i] = isPriceDropped ? j - i : j - i - 1;
        }
        return answer;
    }
}
