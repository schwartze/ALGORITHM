package algorithm;

public class SumOfEvenNumbers {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4};
		int[][] queries = {
				{1,0},
				{-3,1},
				{-4,0},
				{2,3}
				};
		SumOfEvenNumbers evenNumbers = new SumOfEvenNumbers();
		int[] res = evenNumbers.sumEvenAfterQueries2(A, queries);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    	int[] res = new int[A.length];
		
    	for (int i = 0; i < A.length; i++) {
    		int evenSum = 0;
    		A[queries[i][1]] = A[queries[i][1]] + queries[i][0];
    		
    		for (int j = 0; j < A.length; j++) {
        		if (A[j] % 2 != 0)
        			continue;
        		evenSum += A[j];
    		}
    		res[i] = evenSum;
    	}
    	return res;
    }
    
    public int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
    	int[] res = new int[A.length];
    	int evenSum = 0;
		
		for (int n : A)
			if (n % 2 == 0)
				evenSum += n;
		// since iterating all elements can be time consuming 
    	for (int i = 0; i < A.length; i++) {
    		int val = queries[i][0];
    		int index = queries[i][1];

    		if (A[index] % 2 == 0)
    			evenSum -= A[index];
    		A[index] += val;
    		if (A[index] % 2 == 0)
    			evenSum += A[index];

    		res[i] = evenSum;
    	}
    	return res;
    }
}
