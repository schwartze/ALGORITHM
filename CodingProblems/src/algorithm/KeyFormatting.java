package algorithm;

public class KeyFormatting {

	public static void main(String[] args) {
		KeyFormatting theFormatter = new KeyFormatting();
		String result = theFormatter.keyFormatter("2-5G-3J", 2);
		System.out.println(result);
	}
	
	// Format "5F3Z-2e-9-w" to "5F3Z-2E9W"
	// when given integer is 4, reformat the String 
	// so that each group separated by "-" contain every K characters
	// but only the first group can contain letters shorted than K.
	public String getKeyInFormat(String S, int K) {
		
		String result = "";
		
		String str = S.replace("-", "").toUpperCase();
		
		if (str.length() % K == 0) {
			
			int index = 0;
			
			for (char c : str.toCharArray()) {
			
				result += c;
				index++;
				
				if (index == K) {
					index = 0;
					result += "-";
				}
			}
			
		} else {
			
			int remainder = str.length() % K;
			int index = 0;
			
			for (char c : str.toCharArray()) {
				
				result += c;
				index++;
				
				if (index == K || index == remainder) {
					remainder = -1;
					result += "-";
					index = 0;
				}
			}
			
		}
	
		return result.substring(0, result.length() - 1);
	}

	
	public String keyFormatter(String S, int K) {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = S.length() - 1; i >= 0; i--) {
			
			if (S.charAt(i) != '-')
				sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
		}
		
		return sb.reverse().toString().toUpperCase();
	}
}
