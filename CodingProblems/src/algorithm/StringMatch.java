package algorithm;

public class StringMatch {

    public int[] diStringMatch(String s) {
		int[] res = new int[s.length() + 1];
		int max = s.length(), min = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (c == 'I') 
				res[i] = min++;
			else 
				res[i] = max--;
			
			if (i == s.length() - 1) {
				if (c == 'I') 
					res[i + 1] = min++;
				else 
					res[i + 1] = max--;
			}
		}
		return res;
    }
}
