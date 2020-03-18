package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class KeyboardRow {

	// find the words where each letter is located in the same 
	// line of qwerty keyboard
	// when an array of strings is given
	// Input: ["Hello", "Alaska", "Dad", "Peace"]
	// Output: ["Alaska", "Dad"]
	
	public String[] findWords(String[] words) {
		
		HashSet<Character> row1 = stringToSet("qwertyuiop");
		HashSet<Character> row2 = stringToSet("asdfghjkl");
		HashSet<Character> row3 = stringToSet("zxcvbnm");
		
		List<String> result = new ArrayList<>();
		
		for (String word : words)
			if (isValid(row1, word) || isValid(row2, word) || isValid(row3, word))
				result.add(word);
		
		return result.toArray(new String[0]);
	}
	
	private boolean isValid(HashSet<Character> set, String s) {
		
		for (char c : s.toCharArray())
			if (!set.contains(Character.toLowerCase(c)))
				return false;

		return true;
	}
	
	private HashSet<Character> stringToSet(String str) {
		
		HashSet<Character> set = new HashSet<>();
		
		for (char c : str.toCharArray())
			set.add(c);
		
		return set;
	}

	
	public String[] findWords2(String[] words) {
		
		String[] keyboardCharacters = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < keyboardCharacters.length; i++)
			for (char c : keyboardCharacters[i].toCharArray())
				map.put(c, i);

		List<String> result = new ArrayList<>();
		
		for (String word : words) {
			int index = map.get(word.toLowerCase().charAt(0));
			
			for (char c : word.toLowerCase().toCharArray()) {
				
				if (map.get(c) != index) {
					index = -1;
					break;
				}
			}
			if (index != -1)
				result.add(word);
		}
		
		return result.toArray(new String[0]);
	}
}
