package algorithm;

import java.util.HashMap;

public class BullsAndCows {
	
	// using two HashMaps
	public static String getHintWithMaps(String guess, String answer) {
		
		HashMap<Integer, Character> guessMap = putValuesInMap(guess);
		HashMap<Integer, Character> answerMap = putValuesInMap(answer);
		
		int bullCount = 0;
		int cowCount = 0;
		
		for (int i = 0; i < guessMap.size(); i++) {
			
			if (!answerMap.containsValue(guessMap.get(i)))
				continue;	
			
			if (answerMap.get(i) == guessMap.get(i))
				bullCount++;
			else
				cowCount++;
		}
		
		return bullCount + "A" + cowCount + "B";
	}
	
	private static HashMap<Integer, Character> putValuesInMap(String str) {
		HashMap<Integer, Character> resultMap = new HashMap<Integer, Character>();
		
		for (int i = 0; i < str.length(); i++) {
			resultMap.put(i, str.charAt(i));
		}
		
		return resultMap;
	}

	// using int array 
	public static String getHintWithArray(String guess, String answer) {
		
		int cowCount = 0;
		int bullCount = 0;
		
		int[] numbers = new int[10];
		
		for (int i = 0; i < guess.length(); i++) {
			int g = Character.getNumericValue(guess.charAt(i));
			int a = Character.getNumericValue(answer.charAt(i));
			
			if (g == a)
				bullCount++;
			
			else {
				
				if (numbers[g] < 0) 
					cowCount++;
				
				if (numbers[a] > 0) 
					cowCount++;
				numbers[g]++;
				numbers[a]--;
			}
		}
		return bullCount + "A" + cowCount + "B";
	}

	// using nested for loop
	public static String getHintWithNestedFor(String guess, String answer) {
		int bullCount = 0;
		int cowCount = 0;
		
		for (int i = 0; i < guess.length(); i++) {
			
			for (int j = 0; j < answer.length(); j++) {
				
				if (guess.charAt(i) == answer.charAt(i))
					
					if (i == j)
						bullCount++;
					else 
						cowCount++;
			}
		}
		return bullCount + "A" + cowCount + "B";
	}
}

// The problem states: 
// You are playing the following Bulls and Cows game with your friend: 
// You write down a number and ask your friend to guess what the number is. 
// Each time your friend makes a guess, you provide a hint that indicates 
// how many digits in said guess match your secret number exactly in both digit and position (called "bulls") 
// and how many digits match the secret number but locate in the wrong position (called "cows"). 
// Your friend will use successive guesses and hints to eventually derive the secret number.
//
// Write a function to return a hint according to the secret number and friend's guess, 
// use A to indicate the bulls and B to indicate the cows. 
