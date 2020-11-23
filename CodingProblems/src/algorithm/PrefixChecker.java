package algorithm;

public class PrefixChecker {

	public static void main(String[] args) {
		String sentence = "hellohello hellohellohello";
		String searchWord = "ell";
		
		int res = isPrefixOfWord(sentence, searchWord);

		System.out.println(res);
	}
	
    public static int isPrefixOfWord(String sentence, String searchWord) {
    	int res = -1, idx = 1;

    	for (String word : sentence.split(" ")) {
    		if (word.indexOf(searchWord) == 0) {
    			res = idx;
    			break;
    		}
    		idx++;
    	}
    	return res;
    }
}
