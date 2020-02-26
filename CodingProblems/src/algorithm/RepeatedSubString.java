package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RepeatedSubString {

	public static void main(String[] args) {
		
		String str = "abcabcabcabc";
		System.out.println(isRepeatedSubstring(str));
		
	}
	
	
	public static boolean isRepeatedSubstring(String str) {
		
		char temp = str.charAt(0);
		str += " ";
		List<String> sList = new ArrayList<>();

		for (int i = 1, j = 0; i < str.length(); i++) {
			
			if (str.charAt(i) == temp || i == str.length() - 1) {
				sList.add(str.substring(j, i));
				j = i;
			}
		}
		
		for (int i = 0; i < sList.size() - 1; i++) {
			
			if (!sList.get(i).equals(sList.get(i + 1)))
				return false;
		}
		
		return true;
	}
}
