package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {

	public static void main(String[] args) {
		String[] A = {"bella", "label", "roller"};
		String[] B = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
		String[] C = {"cool", "cook", "lock"};
		CommonCharacters common = new CommonCharacters();
		List<String> res = common.commonChars(C);
		
		for (String s : res)
			System.out.print(s + ", ");
	}
	
    public List<String> commonChars(String[] A) {
    	List<String> res = new ArrayList<>();
    	int[] dict = new int[26];
    	
    	for (int i = 0; i < A[0].length(); i++) 
    		dict[A[0].charAt(i) - 97]++;
    	
		
    	for (int i = 1; i < A.length; i++) {
    		int[] curr = new int[26];
    		
    		for (int j = 0; j < A[i].length(); j++) 
    			curr[A[i].charAt(j) - 97]++;
    		
    		for (int j = 0; j < curr.length; j++) 
    			if (curr[j] < dict[j])
    				dict[j] = curr[j];
    	}
    	
    	for (int i = 0; i < dict.length; i++) 
    		for (int j = 0; j < dict[i]; j++) 
    			res.add(String.valueOf((char) (i + 97)));
    	
    	return res;
    }
}
