package algorithm;

public class BinarySubstring {

	public static void main(String[] args) {
		BinarySubstring bSubstring = new BinarySubstring();
		int n = bSubstring.getSubstring("10101");
		System.out.println(n);
	}
	
	// count the number of contiguous substring consists of the same number of 0's and 1's
	public int getSubstring(String s) {
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++ ) {
			StringBuilder temp1 = new StringBuilder();
			
			for (int j = i; j < s.length() - 1; j++) {
				temp1.append(s.charAt(j));
				
				if (s.charAt(j) != s.charAt(j + 1)) {
					StringBuilder temp2 = new StringBuilder();
					
					for (int k = j + 1; k < temp1.length() + j + 1; k++) {
						temp2.append(s.charAt(k));
					}
					
					if (temp1.length() <= temp2.length()) {
						sb.append(temp1).append(temp2).append("_");
						break;
					}
				}
			}
		}
		return sb.toString().split("_").length;
	}
}
