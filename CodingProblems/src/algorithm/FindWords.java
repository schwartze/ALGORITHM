package algorithm;

public class FindWords {

	public static void main(String[] args) {
		String[] words = {"hello","world","leetcode"};
		String chars = "welldonehoneyr";
		FindWords fWords = new FindWords();
		int count = fWords.countCharacters(words, chars);
		System.out.println(count);
	}
	
    public int countCharacters(String[] words, String chars) {
    	int res = 0;
    	
    	for (String word : words) {
    		
    		StringBuilder sb = new StringBuilder(chars);
    		boolean formable = true;
    		for (int i = 0; i < word.length(); i++) {
    			String c = Character.toString(word.charAt(i));
    			int idx = sb.indexOf(c);
    			
    			if (idx < 0) {
    				formable = false;
    				break;
    			}
    			sb.deleteCharAt(idx);
    		}
    		if (formable)
    			res += word.length();
    	}
    	return res;
    }
    
}
