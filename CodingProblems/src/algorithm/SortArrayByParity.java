package algorithm;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] A = {3, 1, 2, 4};
		
		SortArrayByParity sortByParity = new SortArrayByParity();
		int[] res = sortByParity.sortArrayByParity(A);

		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// Sort the array by even elements followed by the odd elements
    public int[] sortArrayByParity(int[] A) {
     
    	int[] B = new int[A.length];
    	
    	for (int i = 0, a = 0, b = A.length; i < A.length; i++) {
    		
    		if (A[i] % 2 == 0) {
    			B[a] = A[i];
    			a++;
    		}
    		else {
    			B[b - 1] = A[i];
    			b--;
    		}
    	}
    	
    	return B;
    }

    
    public int[] sortByParity(int[] A) {
    	int[] res = new int[A.length];
    	
    	for (int i = 0, j = A.length - 1, k = 0; k < A.length; k++) {
    		
    		if (A[k] % 2 == 0) {
    			res[i++] = A[k];
    		} else {
    			res[j++] = A[k];
    		}
    	}
    	
    	return res;
    }
}
