package algorithm;

public class StairClimbing {
	
	public static void main(String[] args) {
		int[] cost = {1,100,1,1,1,100,1,1,100,1};
		int[] cost2 = {10, 15, 20};
		
		int res = minCostClimbingStairs(cost);
		System.out.println(res);
	}

    public static int minCostClimbingStairs(int[] cost) {
    	int minCost = 0;
    	int i;
    	
    	for (i = 0; i < cost.length - 2; i++) {
    		
    		if (cost[i] != cost[i + 2] && cost[i] + cost[i + 2] > cost[i + 1]) {
    			minCost += cost[i + 1];
    		} else {
    			minCost += cost[i];
    			
    			if (cost[i + 1] >= cost[i])
    				i++;
    		}
    	}
    	
    	if (i == cost.length - 1) {
    		minCost += cost[i] > cost[i - 1] ? cost[i - 1] : cost[i];
    	}
    	
    	return minCost;
    }
}
