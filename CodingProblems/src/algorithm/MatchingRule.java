package algorithm;

import java.util.Arrays;
import java.util.List;

public class MatchingRule {
	
	public static void main(String[] args) {
		List<String> item1 = Arrays.asList("phone","blue","pixel");
		List<String> item2 = Arrays.asList("computer","silver","lenovo");
		List<String> item3 = Arrays.asList("phone","gold","iphone");
		List<List<String>> items = Arrays.asList(item1, item2, item3);
		String ruleKey = "color";
		String ruleValue = "silver";
		
		int res = countMatches(items, ruleKey, ruleValue);
		System.out.println(res);
	}
	
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
    	int targetIdx = ruleKey.equals("type") ? 0 : (ruleKey.equals("color") ? 1 : 2);
    	int count = 0;
    	
    	for (List<String> item : items) {
    		if (item.get(targetIdx).equals(ruleValue))
    			count++;
    	}
    	return count;
    }
}
