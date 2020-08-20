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
		int[] res = evenNumbers.sumEvenAfterQueries(A, queries);
		
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
}
