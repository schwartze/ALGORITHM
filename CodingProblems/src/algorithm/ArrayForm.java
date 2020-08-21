package algorithm;

import java.util.LinkedList;
import java.util.List;

public class ArrayForm {

	public static void main(String[] args) {
		int[] A = {9,9,9,9,9,9,9,9,9,9};
		int K = 1;
		
		ArrayForm aForm = new ArrayForm();
		List<Integer> res = aForm.addToArrayForm(A, K);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	/*
	 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order. 
	 * For example, if X = 1231, then the array form is [1, 2, 3, 1].
	 * Given the array-form A of a non-negative integer X, return the array-form of the integer X + K.
	 */
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }
        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
