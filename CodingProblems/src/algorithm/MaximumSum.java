package algorithm;

import java.util.PriorityQueue;

public class MaximumSum {

	public static void main(String[] args) {
		int[] A = {0, -2, 2, -2, 5};
		int[] A2 = {4, 2, 3};
		int[] A3 = {3, -1, 0, 2};
		int[] A4 = {2, -3, -1, 5, -4};
		int[] A5 = {-2, 9, 9, 8, 4};
		int[] A6 = {-2, -1, 2, 4};
		
		
		int K = 3;
		int K2 = 1;
		int K3 = 3;
		int K4 = 2;
		int K5 = 5;
		int K6 = 3;
		
		MaximumSum maxSum = new MaximumSum();
		int res = maxSum.largestSumAfterKNegations2(A6, K6);
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

    public int largestSumAfterKNegations2(int[] A, int k) {
    	PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
    	int sum = 0, negCnt = 0;
    	
    	for (int n : A) {
    		sum += n;
    		queue.add(n);
    		
    		if (n < 0)
    			negCnt++;
    	}
    	
    	while (!queue.isEmpty() && k-- > 0) {
    		int num = queue.poll();

    		if (num < 0)
    			negCnt--;

    		if ((num == 0 || negCnt == 0) && k % 2 != 0) 
				break;
    		
    		sum -= num;
    		sum += num * -1;
    	}
    	return sum;
    }
}
