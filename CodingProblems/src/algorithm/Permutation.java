package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {

	public static void main(String[] args) {
		String S = "a1b2";
		Permutation permutator = new Permutation();
		List<String> res = permutator.letterCasePermutation(S);
		
		for (String s : res) {
			System.out.println(s);
		}
	}
	
    public List<String> letterCasePermutation(String S) {
    	String lowerS = S.toLowerCase();
    	Map<Integer, Character> map = new HashMap<>();
    	
    	for (int i = 0; i < lowerS.length(); i++) {
    		
    		if (Character.isLetter(lowerS.charAt(i))) 
    			map.put(i, lowerS.charAt(i));
    	}

    	int size = (int) Math.pow(map.size(), 2);
    	
    	List<String> list = new ArrayList<>(size);
    	

		for (int n : map.keySet()) {
    		StringBuffer temp = new StringBuffer(S);
			// lowercase
			char c = map.get(n);
			temp.setCharAt(n, c);
			
			if (!list.contains(temp.toString())) 
				list.add(temp.toString());
			
			// uppercase
			char c2 = (char)(c - 32);
			temp.setCharAt(n, c2);
			
			if (!list.contains(temp.toString())) 
				list.add(temp.toString());
		}
    	
    	return list;
    }
}
