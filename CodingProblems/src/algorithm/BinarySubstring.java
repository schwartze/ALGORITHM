package algorithm;

public class BinarySubstring {

	public static void main(String[] args) {
		BinarySubstring bSubstring = new BinarySubstring();
		int n = bSubstring.getSubstring("00110011");
		System.out.println(n);
	}
	
	// count the number of contiguous substring consists of the same number of 0's and 1's
	public int getSubstring(String s) {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder temp1 = new StringBuilder();
		
		for (int i = 0; i < s.length() - 1; i++) {
			temp1.append(s.charAt(i));
			
			if (s.charAt(i) != s.charAt(i + 1)) {
				
				StringBuilder temp2 = new StringBuilder();
				
				for (int j = i + 1; j < temp1.length() + i + 1; j++) 
						temp2.append(s.charAt(j));
					
				if (temp1.length() <= temp2.length())
					sb.append(temp1).append(temp2.substring(0, temp1.length()) + "-");
			}
		}
		return sb.toString().split("-").length;
	}
}
