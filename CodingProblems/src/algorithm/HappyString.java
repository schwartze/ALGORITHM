package algorithm;

public class HappyString {
	
	public static void main(String[] args) {
		int n = 3, k = 9;
		
		getHappyString(n, k);
	}

    public static String getHappyString(int n, int k) {
    	char[] chars = {'a', 'b', 'c'};
    	int[] arr = {k};
    
    	return dfs(chars, arr, ' ', 0, n);
    }
    
    private static String dfs(char[] chars, int[] k, char prev, int index, int n) {
    	if (index == n)
    		k[0]--;
    	else {
    		
    		for (int i = 0; i < 3; i++) {
    			if (chars[i] != prev) {
    				String res = dfs(chars, k, chars[i], index + 1, n);
    				if (k[0] == 0) return chars[i] + res;
    			}
    		}
    	}
    	return "";
    }
}
