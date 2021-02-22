package algorithm;

import java.util.Arrays;

public class MaxCoin {
	
	public static void main(String[] args) {
		int[] piles = {9,8,7,6,5,1,2,3,4};
		int[] piles2 = {2,4,1,2,7,8};
		
		int res = maxCoins(piles2);
		System.out.println(res);
	}
	
    public static int maxCoins(int[] piles) {
    	Arrays.sort(piles);
    	int res = 0;
    	
    	for (int i = piles.length - 2; i >= piles.length / 3; i -= 2) {
    		res += piles[i];
    	}
    	return res;
    }
}
