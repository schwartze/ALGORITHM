package algorithm;

public class JadenCase {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		String s2 = "for the last week";
		String s3 = " hello m y friend "; // => " Hello M Y Friend "
		String s4 = " 2v 3hello m y friend ";
		String s5 = "3peOple unFollowed me";
		String s6 = "3peOple 3unFollowed mE";
		String s7 = " 2v 3hello m y friend 23HIz ";
		String s8 = "Far";
		
		String res = parseToJadenCase(s8);
		System.out.println(res);
	}
	
	public static String parseToJadenCase(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sb.append(s.charAt(i));
				continue;
			}
			
			if (i == 0 && Character.toUpperCase(s.charAt(i)) >= 65 && Character.toUpperCase(s.charAt(i)) <= 90) {
				sb.append(Character.toUpperCase(s.charAt(i)));
				continue;
			}
			
			if (i > 0 && s.charAt(i - 1) == ' ' && Character.toUpperCase(s.charAt(i)) >= 65 && Character.toUpperCase(s.charAt(i)) <= 90) {
				sb.append(Character.toUpperCase(s.charAt(i)));
				continue;
			}
			
			sb.append(Character.toLowerCase(s.charAt(i)));
		}
		return sb.toString();
	}
}
