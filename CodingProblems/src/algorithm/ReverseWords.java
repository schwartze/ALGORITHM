package algorithm;

public class ReverseWords {

	public static void main(String[] args) {
		ReverseWords reverser = new ReverseWords();
		String result = reverser.reverse("Let's take LeetCode contest");
		System.out.println(result);
	}
	
	// reverse the given string while still preserving whitespace 
	// and initial word order
	public String reverse(String s) {
		
		String[] words = s.split(" ");
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < words.length; i++) {
			
			for (int j = words[i].length() - 1; j >= 0; j--) {
				sb.append(words[i].charAt(j));
			}
			sb.append(" ");
		}
		
		return sb.toString();
	}
}
