package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation {

	public static void main(String[] args) {
		String S = "a1b2c3";
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

    	List<String> list = new ArrayList<>();
    	list.add(S);

		for (int n : map.keySet()) {
			
			for (int i = 0; i < list.size(); i++) {
				StringBuffer temp = new StringBuffer(list.get(i));
				char c = map.get(n);

				for (int j = 0; j < 2; j++) {
					
					if (j == 0) 
						temp.setCharAt(n, c);
					else 
						temp.setCharAt(n, (char)(c - 32));
					
					if (!list.contains(temp.toString()))
						list.add(temp.toString());
				}
			}
		}
    	return list;
    }
}
