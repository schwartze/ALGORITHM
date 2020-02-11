package algorithm;

public class ReverseVowels {

	public static void main(String[] args) {
		
		String input = "hello";
		
		String result = reverseVowels(input);

		System.out.println(result);
	}
	
	public static String reverseVowels(String str) {
		String vowels = "aeiouAEIOU";
		char[] charArray = str.toCharArray();
		
		int start = 0; 
		int end = str.length() - 1;
		
		while (start < end) {
			
			while (start < end && !vowels.contains(charArray[start] + ""))
				start++;
			
			while (start < end && !vowels.contains(charArray[end] + ""))
				end--;
			
			char temp = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = temp;
			
			start++;
			end--;
		}
		
		return new String(charArray);
	}
}
