package algorithm;

public class DefuseBomb {

	public static void main(String[] args) {
		int[] code = {5, 7, 1, 4};
		int k = 3;
		
		int[] code2 = {2, 4, 9, 3};
		int k2 = -2;
		
		int[] code3 = {1, 2, 3, 4};
		int k3 = 0;
		
		
		int[] res = decrypt(code3, k3);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	/*
	 * If k > 0, replace the ith number with the sum of the next k numbers.
	 * If k < 0, replace the ith number with the sum of the previous k numbers.
	 * If k == 0, replace the ith number with 0.
	 */
    public static int[] decrypt(int[] code, int k) {
    	int[] res = new int[code.length];
    	
    	if (k == 0)
    		return res;
    	
    	for (int i = 0; i < code.length; i++) {
    		int num = 0, sum = 0;
    		
    		if (k > 0) {
    			while (num++ < k) 
    				sum += code[(num + i) % code.length];
    		} else {
    			while (num-- > k)
    				sum += code[(code.length + (num + i)) % code.length];
    		}
    		res[i] = sum;
    	}
    	return res;
    }
}
