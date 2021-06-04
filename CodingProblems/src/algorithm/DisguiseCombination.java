package algorithm;

import java.util.HashMap;
import java.util.Map;

public class DisguiseCombination {

	public int getCombination(String[][] clothes) {
		Map<String, Integer> map = new HashMap<>();

    	for (String[] item : clothes) 
        	map.put(item[1], map.getOrDefault(item[1], 0) + 1);
        
    	int totalCnt = 0, totalCombination = map.size() > 1 ? 1 : 0;    
        
        for (String item : map.keySet()) {
    		totalCnt += map.get(item);
        	totalCombination *= map.get(item);
        }
        
        return totalCnt + totalCombination;
	}
}
