package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WordsInDictionary {

	public static void main(String[] args) {
		String[] words = {"w","wo","wor","worl", "world"};
		String[] words2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words3 = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
		String[] words4 = {"o","a","ajd","ajdpw","ojowj","okpnd","okpn","ef","oetj","ajdp","ojo","o","ok","oet","o","oj","ojowjy","e"};
		String[] words5 = {"rac","rs","ra","on","r","otif","o","onpdu","rsf","rs","ot","oti","racy","onpd"};
		String[] words6 = {"t","ti","tig","tige","tiger","e","en","eng","engl","engli","englis","english","h","hi","his","hist","histo","histor","history"};
		WordsInDictionary dic = new WordsInDictionary();
		String str = dic.findLongestWord(words4);
		System.out.println(str);
		
		
	}
	//"rac","rs","ra","r","onpdu","rsf","rs","oti","racy"
	// "o", "on", "ot","oti","otif","onpd" 
    public String findLongestWord(String[] words) {
    	Map<Character, List<String>> map = new TreeMap<>();
    	Arrays.sort(words);
    	String res = "";
    	
    	for (String word : words) {
    		if (!map.containsKey(word.charAt(0))) {
        		List<String> wordList = new ArrayList<>();
        		wordList.add(word);
        		map.put(word.charAt(0), wordList);
        		continue;
    		}
    		List<String> list = map.get(word.charAt(0));
    		String lastWord = list.get(list.size() - 1);
    		if (lastWord.length() == word.length() - 1 && 
    				word.indexOf(lastWord) >= 0)
    			list.add(word);
    	}
    	int maxLength = 0;
    	
    	for (List<String> list : map.values()) {
    		String lastWord = list.get(list.size() - 1);
    		if (list.size() > maxLength && lastWord.length() == list.size()) {
    			maxLength = list.size();
    			res = lastWord;
    		}
    	}
    	return res;
    }   
}
