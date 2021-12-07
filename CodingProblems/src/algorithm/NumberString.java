package algorithm;

import java.util.Arrays;
import java.util.List;

public class NumberString {
	
	public static void main(String[] args) {
		String s = "one4seveneight";
		
		int res = getNumber(s);
		System.out.println(res);
	}
	
	public static int getNumber(String s) {
		List<String> strList = Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
		StringBuilder sb = new StringBuilder();
		
		while (s.length() > 0) {
			
			for (int i = 0; i < strList.size(); i++) {
				
				if (s.indexOf(strList.get(i)) == 0) {
					sb.append(i);
					s = s.substring(strList.get(i).length());
				}
			}
			if (s.length() > 0) {
				sb.append(s.substring(0, 1));
				s = s.substring(1);
			}
		}
		
		return Integer.parseInt(sb.toString());
	}
}
