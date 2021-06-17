package algorithm;

import java.util.Arrays;

public class MinimumValue {

	public static void main(String[] args) {
		int[] A = {2, 1};
		int[] B = {3, 4};
		
		int[] A2 = {1, 2, 4};
		int[] B2 = {4, 5, 4};
		
		
		int res = solution(A2, B2);
		System.out.println(res);
	}
	
    public static int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
       
        for (int i = A.length - 1, j = 0; i >= 0; i--) {
        	answer += A[i] * B[j++];
        }
        
        return answer;
    }
}
