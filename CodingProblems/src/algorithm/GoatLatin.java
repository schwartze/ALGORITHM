package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GoatLatin {

	public static void main(String[] args) {
		String S = "I speak Goat Latin";
		String S2 = "The quick brown fox jumped over the lazy dog";
		GoatLatin gLatin = new GoatLatin();
		String res = gLatin.toGoatLatin(S2);
		System.out.println(res);
	}
	
//	If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
//	For example, the word 'apple' becomes 'applema'.
//	 
//	If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
//	For example, the word "goat" becomes "oatgma".
//	 
//	Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
//	For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
	
    public String toGoatLatin(String S) {
    	String[] sArr = S.split(" ");
    	List<String> list = new ArrayList<>(sArr.length);
    	Set<Character> vowelSet = new HashSet<>();
    	vowelSet.add('a');
    	vowelSet.add('e');
    	vowelSet.add('i');
    	vowelSet.add('o');
    	vowelSet.add('u');
    	
    	int i = 0;
    	for (String word : sArr) {
    		StringBuffer tempStr = new StringBuffer(word);
    		char firstLetter = tempStr.charAt(0);
			
			if (vowelSet.contains(Character.toLowerCase(firstLetter)))
				tempStr.append("ma");
			else {
				tempStr.append(firstLetter);
				tempStr.deleteCharAt(0);
				tempStr.append("ma");
			}
			
			for (int j = 0; j < i + 1; j++) {
				tempStr.append("a");
			}
    
    		list.add(tempStr.toString());
    		i++;
    	}
    	
    	StringBuffer res = new StringBuffer();
    	
    	for (String str : list) {
    		res.append(str);
    		res.append(" ");
    	}
    	
    	return res.toString().substring(0, res.toString().length() - 1);
    }
}
