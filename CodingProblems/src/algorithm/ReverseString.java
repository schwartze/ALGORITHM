package algorithm;

public class ReverseString {

	public static void main(String[] args) {
		char[] hello = {'h', 'e', 'l', 'l', 'o'};
		char[] hannah = {'h', 'a', 'n', 'n', 'a', 'H'};
		
		reverseString(hannah);
		
		for (int i = 0; i < hannah.length; i++) {
			System.out.print(hannah[i]);
		}
		
	}
	
	// #1: Iteration Method
	public static void reverseString(char[] inputWords) {
		int i = 0; 
		int j = inputWords.length - 1;
		
		while (i < j) {
			char temp = inputWords[i];
			inputWords[i] = inputWords[j];
			inputWords[j] = temp;
			
			i++;
			j--;
		}
	}
	
	// #2: Recursion Method
	public static void reverseString2(char[] inputWords) {
		helper(inputWords, 0, inputWords.length - 1);
	}
	
	private static void helper(char[] inputWords, int start, int end) {
		
		if (start >= end)
			return;
		
		char temp = inputWords[start];
		// ++ / -- operations are done after the assignment operation is done
		inputWords[start++] = inputWords[end];
		inputWords[end--] = temp;
		
		helper(inputWords, start, end);
	}
}
