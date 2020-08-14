package algorithm;

public class SortArrayByParityII {

	public static void main(String[] args) {
		int[] A = {4, 2, 5, 7};
		SortArrayByParityII sortByParity = new SortArrayByParityII();
		int[] res = sortByParity.sortArrayByParityII(A);
		
		for (int n : res) 
			System.out.print(n + ", ");
	}
	
	
	// when A[i] is odd, i is odd; 
	// when A[i] is even, i is even
    public int[] sortArrayByParityII(int[] A) {
     
    	int[] res = new int[A.length];
    	int[] evens = new int[A.length / 2];
    	int[] odds = new int[A.length / 2];
    	
    	for (int i = 0, e = 0, o = 0; i < A.length; i++) {
    		
    		if (A[e] % 2 == 0) {
    			evens[e] = A[i];
    			e++;
    		} else {
    			odds[o] = A[i];
    			o++;
    		}	
    	}
    		
    	for (int i = 0, e = 0, o = 0; i < res.length; i++) {
    		
    		if (i % 2 == 0) {
    			res[i] = evens[e];
    			e++;
    		}
    		else {
    			res[i] = odds[o];
    			o++;
    		}
    	}
    	
    	return res;
    }
}
