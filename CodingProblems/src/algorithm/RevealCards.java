package algorithm;

import java.util.Arrays;

public class RevealCards {

	public static void main(String[] args) {
		int[] deck = {2, 3, 5, 7, 11, 13, 17};
		
		int[] res = deckRevealedIncreasing(deck);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] deckRevealedIncreasing(int[] deck) {
    	int[] res = new int[deck.length];
    	int mid = deck.length / 2;
    	Arrays.sort(deck);
    	
    	int i = 0, j = 0;
    	for (i = 0; j < mid; i += 2, j++) {
    		res[i] = deck[j];
    		res[i + 1] = deck[mid + j];
    	}
    	res[i] = deck[i];
    	
    	return res;
    }
}
