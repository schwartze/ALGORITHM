package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RingsAndRods {
    
	public int countPoints(String rings) {
		Map<Integer, List<Character>> map = new HashMap<>();
		
		for (int i = 0; i < rings.length(); i+=2) {
			int n = Integer.parseInt(rings.charAt(i + 1) + "");			
			List<Character> list = new ArrayList<>();
			
			if (map.containsKey(n)) {
				map.get(n).add(rings.charAt(i));
			} else {
				list.add(rings.charAt(i));
				map.put(n, list);
			}
		}
    	return map.size();
    }
}
