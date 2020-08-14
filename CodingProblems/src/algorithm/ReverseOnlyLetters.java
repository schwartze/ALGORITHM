package algorithm;

import java.util.ArrayList;
import java.util.List;

public class ReverseOnlyLetters {
    
	public static void main(String[] args) {
		String S = "Test1ng-Leet=code-Q!";
		ReverseOnlyLetters reverseLetters = new ReverseOnlyLetters();
		
		String res = reverseLetters.reverseOnlyLetters(S);
		System.out.println(res);
	}
	
	public String reverseOnlyLetters(String S) {
		List<Character> cList = new ArrayList<>();
		StringBuilder sb = new StringBuilder(S.replaceAll("[a-zA-Z]", "A"));
		

		// Find all letters in S and store them into a list
		for (int i = 0; i < S.length(); i++) {
			
			if ((S.charAt(i) > 64 && S.charAt(i) < 91) || (S.charAt(i) > 96 && S.charAt(i) < 123)) {
				cList.add(S.charAt(i));
			}
		}
		
		// Replace all letters in the original S into new letters 
		for (int i = 0, j = cList.size() - 1; i < sb.length(); i++) {
			
			if (sb.charAt(i) != 65)
				continue;
			sb.setCharAt(i, cList.get(j));
			j--;
		}
		
		return sb.toString();
    }

}
