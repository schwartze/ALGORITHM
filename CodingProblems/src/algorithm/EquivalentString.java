package algorithm;

public class EquivalentString {

	public static void main(String[] args) {
		String[] word1 = {"abc", "d", "defg"};
		String[] word2 = {"abcddefg"};
						
		boolean res = arrayStringsAreEqual(word1, word2);
		System.out.println(res);
	}
	
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    	StringBuilder sb = new StringBuilder();
    	
    	for (String word : word1)
    		sb.append(word);
    	
    	for (String word : word2) {
    		if (sb.indexOf(word) < 0)
    			return false;
    		sb.delete(sb.indexOf(word), sb.indexOf(word) + word.length());
    	}
    	return sb.length() == 0;
    }
}
