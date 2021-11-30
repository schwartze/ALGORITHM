package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
    	List<List<String>> result = new ArrayList<>();
    	
    	for (String str : strs) {
    		
    		if (result.size() == 0) {
    			List<String> arr = new ArrayList<>();
    			arr.add(str);
    			result.add(arr);
    			continue;
    		} 
    		
    		for (List<String> strList  : result) {
    			if (isAnagram(strList.get(0), str)) {
    				strList.add(str);
    			} else {
        			List<String> arr = new ArrayList<>();
        			arr.add(str);
        			result.add(arr);
    			}
    		}
    	}
    	return result;
    }
    
    private boolean isAnagram(String str1, String str2) {
    	
    	if (str1.length() != str2.length())
    		return false;
    	
    	for (char c : str1.toCharArray()) {
    		if (str2.indexOf(c) < 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}
