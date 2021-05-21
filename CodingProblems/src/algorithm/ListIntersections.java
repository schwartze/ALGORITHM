package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListIntersections {
	
	public static void main(String[] args) {
		int[][] firstList = { {0,2}, {5,10}, {13,23}, {24,25} };
		int[][] secondList = { {1,5}, {8,12}, {15,24}, {25,26} };
		
		int[][] firstList2 = { {1,7} };
		int[][] secondList2 = { {3,10} };
		
		
		int[][] res = intervalIntersection(firstList2, secondList2);
		
		for (int[] nums : res)
			System.out.println(nums[0] + ", " + nums[1]);
	}

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    	if (firstList.length == 0 || firstList.length == 0)
    		return new int[][] {};
    	
    	Queue<int[]> firstQ = new LinkedList<>();
    	Queue<int[]> secondQ = new LinkedList<>();
    	
    	for (int[] firstNums : firstList) {
    		firstQ.add(firstNums);
    	}
    	
    	for (int[] secondNums : secondList) {
    		secondQ.add(secondNums);
    	}
    	
    	List<int[]> list = new ArrayList<>();
    	
    	while (!firstQ.isEmpty() && !secondQ.isEmpty()) {
    		int[] firstNums = firstQ.peek();
    		int[] secondNums = secondQ.peek();
    		
    		int[] nums = new int[2];
    		nums[0] = Math.max(firstNums[0], secondNums[0]);
    		nums[1] = Math.min(firstNums[1], secondNums[1]);
    		list.add(nums);
    		
    		if (firstNums[1] < secondNums[1]) 
    			firstQ.poll();
    		
    		if (!firstQ.isEmpty() && (secondNums[1] <= firstNums[0] || secondNums[1] < firstQ.peek()[0])) 
    			secondQ.poll();
    	}
    	
    	int[][] res = new int[list.size()][2];
    	
    	for (int i = 0; i < list.size(); i++) {
    		res[i] = list.get(i);
    	}
    	
    	return res;
    }
}
