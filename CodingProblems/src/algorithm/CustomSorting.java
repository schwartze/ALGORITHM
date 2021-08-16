package algorithm;

import java.util.HashMap;
import java.util.Map;

public class CustomSorting {

	public static void main(String[] args) {
		String order = "cba";
		String s = "abcd";
		
		String order2 = "cbafg";
		String s2 = "abcd";
		
		String res = customSortString(order2, s2);
		System.out.println(res);
	}
	
    public static String customSortString(String order, String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	StringBuilder sb = new StringBuilder();
    	
    	for (char c : s.toCharArray()) 
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	
    	for (char c : order.toCharArray()) {
    		if (!map.containsKey(c))
    			continue;
    		for (int i = 0; i < map.get(c); i++) 
    			sb.append(c);
    		map.remove(c);
    	}
    	
    	for (char c : map.keySet()) 
    		for (int i = 0; i < map.get(c); i++)
    			sb.append(c);
    	
    	return sb.toString();
    }
}
