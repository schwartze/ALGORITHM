package algorithm;

import java.util.Arrays;

public class LargestElement {

	public static void main(String[] args) {
		int k = 3;
		int[] arr = {4, 5, 8, 2};
		
		KthLargest kthLargest = new KthLargest(k, arr);
		int a = kthLargest.add(3);
		int b = kthLargest.add(5);
		int c = kthLargest.add(10);
		int d = kthLargest.add(9);
		int e = kthLargest.add(4);
		
		System.out.println(a + ", " + b + ", " + c + ", " + d + ", " + e);
	}
	
}

class KthLargest {
	int k;
	int[] arr;
	
	public KthLargest(int k, int[] arr) {
		this.k = k;
		this.arr = arr;
	}
	
	public int add(int a) {
		addToArray();
		arr[arr.length - 1] = a;
		
		Arrays.sort(arr);
		
		return arr[arr.length - k];
	}
	
	private void addToArray() {
		int[] newArr = new int[arr.length + 1];
		
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		arr = newArr;
	}
}