package algorithm;

public class AccountGenerator {

	public static void main(String[] args) {
		String id = "abcdefghijklmn.p";
		String res = generateValidAccount(id);
		System.out.println(res);
	}
	
	public static String generateValidAccount(String id) {
		String lowercasedId = id.toLowerCase();
		String validStr = lowercasedId.replaceAll("[^a-z|0-9|_|.|-]", "");
		String cleanedStr = validStr.replaceAll("\\.++", ".");
		
		if (cleanedStr.charAt(0) == '.')
			cleanedStr = cleanedStr.substring(1, cleanedStr.length());

		if (cleanedStr.length() > 15) 
			cleanedStr = cleanedStr.substring(0, 15);
		
		if (cleanedStr.length() > 0 && cleanedStr.charAt(cleanedStr.length() - 1) == 46)
			cleanedStr = cleanedStr.substring(0, cleanedStr.length() - 1);
		
		if (cleanedStr.isEmpty() || cleanedStr.length() <= 0) 
			cleanedStr = "a";
		
		if (cleanedStr.length() <= 2) {
			StringBuilder sb = new StringBuilder(cleanedStr);
			char lastWord = cleanedStr.charAt(cleanedStr.length() - 1);

			if (cleanedStr.length() == 1) {
				sb.append(lastWord);
				sb.append(lastWord);
			} else {
				sb.append(lastWord);
			}
			cleanedStr = sb.toString();
		}
		
		return cleanedStr;
	}
	
}
