package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		String[] strs2 = {"ddddddddddg","dgggggggggg"};
		
		GroupAnagrams anagrams = new GroupAnagrams();
		List<List<String>> result =  anagrams.groupAnagrams(strs);
		
		for (List<String> list : result) {
			for (String s : list) {
				System.out.print(s + ", ");
			}
			System.out.println();
		}
	}
	

    public List<List<String>> groupAnagrams(String[] strs) {
    	if (strs == null || strs.length == 0)
    		return new ArrayList<>();
    	
    	Map<String, List<String>> map = new HashMap<>();
    	
    	for (String str : strs) {
    		char[] charArr = new char[26];
    		
    		for (char c : str.toCharArray()) {
    			charArr[c - 'a']++;
    		}
    		String keyStr = String.valueOf(charArr);
    		if (!map.containsKey(keyStr)) {
    			map.put(keyStr, new ArrayList<>());
    		}
    		map.get(keyStr).add(str);
    	}
    	return new ArrayList<>(map.values());
    }
    
}
