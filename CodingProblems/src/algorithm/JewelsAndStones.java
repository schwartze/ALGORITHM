package algorithm;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones {

	public static void main(String[] args) {
		String J = "aA";
		String S = "aAAbbbb";
		
		JewelsAndStones jAS = new JewelsAndStones();
		int res = jAS.numJewelsInStones(J, S);
		System.out.println(res);
	}
	
	
    public int numJewelsInStones(String J, String S) {
     
    	Map<Character, Integer> map = new HashMap<>();
    	int res = 0;
    	
    	for (char c : S.toCharArray()) {
    	
    		int count = map.getOrDefault(c, 0);
    		map.put(c, count + 1);
    	}
    	
    	for (char c : J.toCharArray()) {
    		
    		if (!map.containsKey(c))
    			continue;
    		res += map.get(c);
    	}
    	
    	return res;
    }
}
