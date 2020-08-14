package algorithm;

import java.util.HashMap;
import java.util.Map;

public class DeckOfCards {
	
	public static void main(String[] args) {
		int[] deck = {1, 1, 2, 2, 2, 2};
		DeckOfCards dCards = new DeckOfCards();
		
		boolean res = dCards.hasGroupsSizeX(deck);
		System.out.println(res);
	}

	/*
	 *  In a deck of cards, each card has an integer written on it.
	 *	Return true if and only if you can choose X >= 2 such that 
	 *	it is possible to split the entire deck into 1 or more groups of cards, where:
	 *		Each group has exactly X cards.
	 *		All the cards in each group have the same integer.
	 */
    public boolean hasGroupsSizeX(int[] deck) {
    	
    	Map<Integer, Integer> deckMap = new HashMap<>();
    	int min = Integer.MAX_VALUE;
    	
    	// 1. Save deck into a map: value, count 
    	for (int n : deck) {
    		
    		int count = deckMap.getOrDefault(n, 0);
    		deckMap.put(n, count + 1);
    	}
    	
    	// 2. Find the smallest (must be greater than 1) count of value
    	for (int key : deckMap.keySet()) {
    		min = Math.min(min, deckMap.get(key));
    	}
    	
    	// 3. Final check 
    		// cannot be 1 
    	if (min == 1)
    		return false;
    	
    		// all the cards in each group have the same integer
    	for (int key : deckMap.keySet()) {
    		int value = deckMap.get(key);
    		if (value > min && value % min != 0)
    			return false;
    	}
    	
    	return true;
    }
}
