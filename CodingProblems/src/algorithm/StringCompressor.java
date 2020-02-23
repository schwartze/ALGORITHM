package algorithm;

import java.util.HashMap;

public class StringCompressor {

	public static void main(String[] args) {
		char[] charArr = {'a', 'a', 'b', 'b', 'a', 'a', 'a'};
		System.out.println(compressor(charArr));
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

	// the above solution doesn't work when the given char array are like this: {a, a, b, b, a, a, a}
	// another solution using two pointers
	public static int compressor(char[] charArray) {
		int index = 0; 
		int result = 0;
		
		while (index < charArray.length) {
			
			char currentChar = charArray[index];
			int count = 0;
			
			while (index < charArray.length && charArray[index] == currentChar) {
				index++;
				count++;
			}
			
			charArray[result++] = currentChar;
			
			for (char c : Integer.toString(count).toCharArray())
				charArray[result++] = c;
		}
		
		return result;
	}

}
