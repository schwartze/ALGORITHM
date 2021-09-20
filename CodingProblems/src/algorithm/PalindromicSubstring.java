package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstring {

	public static void main(String[] args) {
		PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
		String s = "abc";
		String s2 = "aaa";
		int palindromicCount = palindromicSubstring.countSubstrings(s);
		System.out.println(palindromicCount);
	}
	
	public int countSubstrings(String s) {
		List<String> palindromicList = new ArrayList<>();
		helper(palindromicList, "", s, 0);
		return palindromicList.size() + s.length() - 1;
    }
	
	private void helper(List<String> list, String str, String s, int idx) {
		if (str.length() == s.length()) {
			str = "";
			return;
		}
		
		for (int i = idx; i < s.length(); i++) {
			str = str + s.charAt(i);
			StringBuilder sb = new StringBuilder(str);
			
			if (str.equals(sb.reverse().toString()) && !list.contains(str.toString())) {
				list.add(str.toString());
			}
			helper(list, str, s, idx + 1);
		}
	}
}
