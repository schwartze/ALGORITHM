package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IncreasingDecreasing {

	public static void main(String[] args) {
		String s = "aaaabbbbcccc";
		String res = sortString(s);
		System.out.println(res);
	}
	
	/*
	 * Given a string s. You should re-order the string using the following algorithm:
	 * Pick the smallest character from s and append it to the result.
	 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
	 * Repeat step 2 until you cannot pick more characters.
	 * Pick the largest character from s and append it to the result.
	 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
	 * Repeat step 5 until you cannot pick more characters.
	 * Repeat the steps from 1 to 6 until you pick all characters from s.
	 * In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
	 */
    public static String sortString(String s) {
    	StringBuilder res = new StringBuilder();
    	Map<Character, Integer> map = new TreeMap<>();
    	
    	for (int i = 0; i < s.length(); i++)
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    	
    	while (map.size() > 0) {
    		res.append(helper(map, 0));
    		res.append(helper(map, 1));
    	}
    	
    	return res.toString();
    }
    
    private static String helper(Map<Character, Integer> map, int type) {
    	StringBuilder sb = new StringBuilder();
    	List<Character> cList = new ArrayList<>();
    	
    	for (char key : map.keySet()) {
    		
    		if (map.get(key) <= 0) {
    			cList.add(key);
    			continue;
    		}
    		sb.append(key);
    		map.put(key, map.get(key) - 1);
    	}
    	
    	for (int i = 0; i < cList.size(); i++)
    		map.remove(cList.get(i));
    	
    	return type == 0 ? sb.toString() : sb.reverse().toString();
    }
}
