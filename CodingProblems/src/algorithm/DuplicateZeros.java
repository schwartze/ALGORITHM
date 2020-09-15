package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeros {

	public static void main(String[] args) {
		int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
		int[] arr2 = {1, 5, 2, 0, 6, 8, 0, 6, 0};
		
		DuplicateZeros dZeros = new DuplicateZeros();
		dZeros.duplicateZeros(arr2);

		for (int n : arr2)
			System.out.print(n + ", ");
	}
	
    public void duplicateZeros(int[] arr) {
    	Queue<Integer> queue = new LinkedList<>();
    	int idx = 0;
    	
    	for (int n : arr)
    		queue.add(n);
    	
    	while (!queue.isEmpty() && idx < arr.length) {
    		int num = queue.poll();
    		
    		arr[idx] = num;
    		idx++;
    		if (num == 0 && idx + 1 <= arr.length) 
    			arr[idx++] = num;
    	}
    }
}
