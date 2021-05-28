package algorithm;

import java.util.HashMap;
import java.util.Map;

public class NewsCluster {

	public static void main(String[] args) {
		String str1 = "FRANCE", str2 = "french"; // 16384 =
		
		String str3 = "handshake", str4 = "shake hands"; // 65536 
		
		String str5 = "aa1+aa2", str6 = "AAAA12"; // 43690 
		
		String str7 = "E=M*C^2", str8 = "e=m*c^2";
		
		NewsCluster cluster = new NewsCluster();
		int res = cluster.solution(str7, str8);
		System.out.println(res);
	}
	
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = getPairFrequency(str1);
        Map<String, Integer> map2 = getPairFrequency(str2);
        	
        int xCnt = 0, uCnt = 0;
        
        for (String key : map1.keySet()) {
        	if (map2.containsKey(key)) {
        		xCnt += Math.min(map1.get(key), map2.get(key));
        		uCnt += Math.max(map1.get(key), map2.get(key));
        		continue;
        	} 
        	uCnt += map1.get(key);
        }
    
        for (String key : map2.keySet()) {
        	if (map1.containsKey(key)) {
        		continue;
        	} 
        	uCnt += map2.get(key);
        }
    
        return uCnt > 0 ? xCnt * 65536 / uCnt : 65536;
    }
    
    
    public Map<String, Integer> getPairFrequency(String s) {
    	Map<String, Integer> pairMap = new HashMap<>();
    	
    	for (int i = 0; i < s.length() - 1; i++) {
    		String str = s.substring(i, i + 2).toLowerCase();
    		String pair = str.replaceAll("[^a-z]", "");
    		
    		if (!pair.equals(str))
    			continue;
    		
    		System.out.println(s + ": ====> " + pair);
    		pairMap.put(pair, pairMap.getOrDefault(pair, 0) + 1);
    	}
    	
    	return pairMap;
    }
}
