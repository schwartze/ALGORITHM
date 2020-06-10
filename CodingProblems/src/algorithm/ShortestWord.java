package algorithm;

import java.util.HashMap;
import java.util.Stack;

public class ShortestWord {
	
	/*
	 * Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate. Such a word is said to complete the given string licensePlate
	 * Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
	 * It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.
	 * The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.
	 */
	
	public static void main(String[] args) {
		String[] words = {"step", "steps", "stripe", "stepple"};
		String[] words2 = {"looks", "pest", "stew", "show"};
		String[] words3 = {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"};
		
		String licensePlate = "1s3 PSt";
		String licensePlate2 = "1s3 456";
		String licensePlate3 = "OgEu755";
		
		
		ShortestWord sWord = new ShortestWord();
		String ans = sWord.shortestCompletingWord(licensePlate3, words3);
		System.out.println(ans);
	}

    public String shortestCompletingWord(String licensePlate, String[] words) {
     
    	Stack<Character> cStack = new Stack<>();
    	String ans = "";
    	int minLen = 16;
    	
    	for (char c : licensePlate.toCharArray()) {
    		int temp = Character.toLowerCase(c);
    		
    		if (temp > 96 && temp < 123) {
    			cStack.push((char) temp);
    		}
    	}
    	
    	for (String word : words) {
    		
    		HashMap<Character, Integer> map = new HashMap<>();
    		Stack<Character> temp = new Stack<>();
    		temp.addAll(cStack);
    		boolean contains = true;
    		
    		for (char c : word.toCharArray()) {
    			int count = map.getOrDefault(c, 0);
    			map.put(c, count + 1);
    		}
    		
    		while (!temp.isEmpty()) {
    			char letter = temp.pop();
    			
    			if (!map.containsKey(letter) || map.get(letter) <= 0) {
    				contains = false;
    				break;
    			}
    			map.put(letter, map.get(letter) - 1);
    		}
    		
    		if (contains && word.length() < minLen) {
    			ans = word;
    			minLen = word.length();
    		}
    	}

    	return ans;
    }
}
