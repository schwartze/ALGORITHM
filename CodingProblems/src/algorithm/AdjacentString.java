package algorithm;

public class AdjacentString {

	public static void main(String[] args) {
		String s = "cdcd";
		int res = removeairString(s);
		System.out.println(res);
	}
	
	public static int removeairString(String s) {
		StringBuilder sb = new StringBuilder(s);
		boolean containsPair = true;
		
		while (sb.length() > 0 && containsPair) {
			boolean pair = false;
			
			for (int i = 0; i < sb.length() - 1; i++) {
				
				if (sb.charAt(i) == sb.charAt(i + 1)) {
					sb.delete(i, i + 2);
					pair = true;
				}
			}
			if (!pair)
				containsPair = pair;
		}
		return sb.length() > 0 ? 1 : 0;
	}
}
