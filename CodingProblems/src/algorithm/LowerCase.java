package algorithm;

public class LowerCase {

	public static void main(String[] args) {
		LowerCase lowercase = new LowerCase();
		String res = lowercase.toLowerCase("al&phaBET");
		System.out.println(res);
	}
	
	public String toLowerCase(String str) {
		
		StringBuilder sb = new StringBuilder();
		
		for (char c : str.toCharArray()) {

			if (c - 64 < 0)
				sb.append(c);
			else if (c - 64 >= 0 && c - 97 < 0)		
				sb.append((char)(c + 32));
			else 
				sb.append(c);
		}
		
		return sb.toString();
	}
}
