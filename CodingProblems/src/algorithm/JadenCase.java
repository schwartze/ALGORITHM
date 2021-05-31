package algorithm;

public class JadenCase {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		String s2 = "for the last week";
		
		String res = parseToJadenCase(s2);
		System.out.println(res);
	}
	
	public static String parseToJadenCase(String s) {
		StringBuilder sb = new StringBuilder();
		
		String[] wordArr = s.split(" ");
		
		for (String str : wordArr) {
			String lowercased = str.toLowerCase();
			
			if (lowercased.charAt(0) >= 97 && lowercased.charAt(0) <= 122) {
				String parsed = Character.toUpperCase(lowercased.charAt(0)) + lowercased.substring(1);
				sb.append(parsed);
				sb.append(" ");
				continue;
			}
			sb.append(lowercased);
			sb.append(" ");
		}
		
		return sb.toString();
	}
}
