package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		Map<String, List<String>> map = new HashMap<>();
		map.put("2", Arrays.asList("a", "b", "c"));
		map.put("3", Arrays.asList("d", "e", "f"));
		map.put("4", Arrays.asList("g", "h", "i"));
		map.put("5", Arrays.asList("j", "k", "l"));
		map.put("6", Arrays.asList("m", "n", "o"));
		map.put("7", Arrays.asList("p", "q", "r", "s"));
		map.put("8", Arrays.asList("t", "u", "v"));
		map.put("9", Arrays.asList("w", "x", "y", "z"));
		
		
		List<String> list1 = digits.length() > 0 ? map.get(digits.charAt(0) + "") : new ArrayList<>();
		List<String> list2 = digits.length() > 1 ? map.get(digits.charAt(1) + "") : new ArrayList<>();
		List<String> list3 = digits.length() > 2 ? map.get(digits.charAt(2) + "") : new ArrayList<>();
		List<String> list4 = digits.length() > 3 ? map.get(digits.charAt(3) + "") : new ArrayList<>();
		List<String> result = new ArrayList<>();
			
		for (int i = 0; i < list1.size(); i++) {
			StringBuilder sb = new StringBuilder(list1.get(i));
			for (int j = 0; j < list2.size(); j++) {
				sb.append(list2.get(j));
				for (int k = 0; k < list3.size(); k++) {
					sb.append(list2.get(k));
					for (int l = 0; l < list4.size(); l++) {
						sb.append(list2.get(l));
					}
				}
			}
			result.add(sb.toString());
		}
		return result;
    }
	
}
