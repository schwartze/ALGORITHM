package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpecialStrings {

	public static void main(String[] args) {
		String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
		
		SpecialStrings spStrings = new SpecialStrings();
		int n = spStrings.numSpecialEquivGroups(A);
		
		System.out.println(n);
	}
	
	// A move onto the string consists of swapping any two even indexed characters of S, 
	// or any two odd indexed characters.
	// Two strings are special-equivalent if after any number of moves onto one of them
	// they become equal 
    public int numSpecialEquivGroups(String[] A) {
     
    	Set<String> set = new HashSet<>();
    	List<List<String>> list = new ArrayList<>();
    	
    	for (String word : A) {
    		set.add(word);
    	}
    	
    	for (String str : set) {
    		List<String> subList = new ArrayList<>();
    		boolean hasValue = false;
    		for (List<String> sList : list) {

    			if (sList.contains(str)) {
    				hasValue = true;
    				continue;
    			}
    		}
    		if (hasValue)
    			continue;
    		subList.add(str);
    		
    		StringBuffer sb = new StringBuffer(str);
			for (int i = 0; i < str.length(); i++) {
    			
    			for (int j = i + 2; j < str.length(); j+=2) {
    				char temp = str.charAt(i);
    				sb.setCharAt(i, str.charAt(j));
    				sb.setCharAt(j, temp);
    			}
    			if (set.contains(sb.toString()) && !subList.contains(sb.toString()))
    				subList.add(sb.toString());
    		}
			list.add(subList);
    	}
    	return list.size();
    }
}
