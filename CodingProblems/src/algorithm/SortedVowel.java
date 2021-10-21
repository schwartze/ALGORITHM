package algorithm;

public class SortedVowel {
	
	public static void main(String[] args) {
		int n = 2;
		int res = countVowelStrings(n);
		System.out.println(res);
	}

    public static int countVowelStrings(int n) {
    	int a = 1, e = 1, i = 1, o = 1, u = 1;
    	
    	while (n > 1) {
    		a = (a + e + i + o + u);
    		e = (e + i + o + u);
    		i = (i + o + u);
    		o = (o + u);
    		n--;
    	}
    	
    	return a + e + i + o + u;
    }
  
}
