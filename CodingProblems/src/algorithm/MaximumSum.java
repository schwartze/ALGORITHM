package algorithm;

import java.util.PriorityQueue;

public class MaximumSum {

	public static void main(String[] args) {
		int[] A = {0, -2, 2, -2, 5};
		int K = 3;
		MaximumSum maxSum = new MaximumSum();
		int res = maxSum.largestSumAfterKNegations(A, K);
		System.out.println(res);
	}
	
    public int largestSumAfterKNegations(int[] A, int K) {
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	int sum = 0;
    	
    	for (int n : A) {
    		pq.add(n);
    		sum += n;
    	}

    	while (K-- > 0) {
    		int num = -pq.poll();
    		sum += (num * 2);
    		pq.add(num);
    	}
    	return sum;
    }
}
