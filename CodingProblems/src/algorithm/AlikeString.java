package algorithm;

public class AlikeString {

	public static void main(String[] args) {
		String s = "AbCdEfGh";
		boolean res = halvesAreAlike(s);
		System.out.println(res);
	}
	// given string halves are alike 
	// when the halves of the string contains same number of vowels 
    public static boolean halvesAreAlike(String s) {
    	char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    	int[] vowelsArr = new int[26];
    	int vowelLen = 0;
    	
    	for (char v : vowels)
    		vowelsArr[v - 'a']++;
    	
    	for (int i = 0; i < s.length(); i++) {
    		
    		if (vowelsArr[Character.toLowerCase(s.charAt(i)) - 'a'] > 0 && i >= s.length() / 2)
    			vowelLen++;
    		
			if (vowelsArr[Character.toLowerCase(s.charAt(i)) - 'a'] > 0 && i < s.length() / 2)
    			vowelLen--;
    	}
    	
    	return vowelLen == 0;
    }
}
