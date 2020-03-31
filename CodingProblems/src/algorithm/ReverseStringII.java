package algorithm;

public class ReverseStringII {

	public static void main(String[] args) {
		ReverseStringII reverse = new ReverseStringII();
		String result = reverse.reverseString("abcde", 2);
		System.out.println(result);
	}
	
	public String reverseString(String s, int k) {
		
		// reverse the first k characters for every 2k characters
		
		// less than k characters left, reverse all of them 
		
		// less than 2k but greater than or equal to k characters, 
		// reverse the first k characters only
		
		char[] strToCharStr = s.toCharArray();
		
		for (int start = 0; start < strToCharStr.length; start += 2 * k) {
			int i = start; 
			int j = Math.min(start + k - 1, strToCharStr.length - 1);
			
			while (i < j) {
				char temp = strToCharStr[i];
				strToCharStr[i++] = strToCharStr[j];
				strToCharStr[j--] = temp;
			}
		}
		return new String(strToCharStr);
	}
}
