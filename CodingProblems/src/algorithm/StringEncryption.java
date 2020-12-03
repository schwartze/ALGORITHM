package algorithm;

public class StringEncryption {

	public static void main(String[] args) {
		String s = "a B z";
		int n = 4;
		String res = encrypt(s, n);
		System.out.println(res);
	}
	
	public static String encrypt(String s, int n) {
		StringBuilder sb = new StringBuilder();
		
		for (char c : s.toCharArray())
			sb.append(helper(c, n));
		
		return sb.toString();
	}
	
	private static String helper(char c, int n) {
		
		if (c >= 65 && c <= 90) {
			
			if ((c + n) / 90 > 0)
				c = (char)(64 + ((c + n) % 90));
			else 
				c += n;
		}
		
		if (c >= 97 && c <= 122) {
			
			if ((c + n) / 122 > 0)
				c = (char)(96 + ((c + n) % 122));
			else 
				c += n;
		}
		
		return c + "";
	}
}
