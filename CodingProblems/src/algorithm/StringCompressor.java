package algorithm;

import java.util.HashMap;

public class StringCompressor {

	public static void main(String[] args) {
		char[] charArr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
		System.out.println(compresseString(charArr));
	}
	
	// the given array of characters {a, a, b, b, c, c, c}
	// can be rearranged into a new array {a, 2, b, 2, c, 3}
	// return the size of the new array, the above case, the return value is 6
	public static int compresseString(char[] charArr) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (char c : charArr) {
			int count = map.getOrDefault(c, 0);
			map.put(c, count + 1);
		}
		
		return map.size() * 2;
	}
}
