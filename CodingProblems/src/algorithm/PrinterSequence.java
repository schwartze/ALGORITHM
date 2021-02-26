package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PrinterSequence {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		int[] priorities2 = {2, 1, 3, 2};
		int location2 = 2;
		
		
		int res = solution(priorities2, location2);
		System.out.println(res);
	}
	
    public static int solution(int[] priorities, int location) {
        int answer = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
        	int[] arr = {priorities[i], i};
        	queue.add(arr);
        }
        Arrays.sort(priorities);
        
        for (int i = priorities.length - 1; i >= 0; i--) {
        	while (priorities[i] != queue.peek()[0]) 
        		queue.add(queue.poll());
        	
        	if (queue.peek()[1] == location)
        		break;
        	answer++;
        	queue.poll();
        }
        return answer;
    }
}
