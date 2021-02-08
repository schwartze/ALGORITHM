package algorithm;

public class Heap {

	int size;
	int[] heap = new int[10000];
	
	public void push(int data) {
		int target = size + 1;
		
		while (target != 1 && heap[target / 2] < data) {
			heap[target] = heap[target / 2];
			target /= 2;
		}
		heap[target] = data;
		size++;
	}
	
	public void pop() {
		int parent = 1, child = 2;
		int temp = heap[size];
		
		while (child < size) {
			
			if (child + 1 < size && heap[child] < heap[child + 1]) {
				child++;
			}
			
			if (heap[child] <= temp) {
				break;
			}

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;
		size--;
	}
}
