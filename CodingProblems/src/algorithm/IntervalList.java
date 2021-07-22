package algorithm;

import java.util.ArrayList;
import java.util.List;

public class IntervalList {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    	if (firstList.length == 0 || secondList.length == 0)
    		return firstList.length == 0 ? firstList : secondList;
    	
    	List<int[]> list = new ArrayList<>();
    	int minLen = Math.min(firstList.length, secondList.length);
    	
    	int[] A = new int[2];
    	int[] B = new int[2];
    	
    	for (int i = 0; i < minLen; i++) {
    		if (i < minLen && firstList[i + 1][0] == B[1])
    			list.add(new int[] {B[1], B[1]});
    		
    		A = firstList[i];
    		B = secondList[i];
    		
    		int[] intersection = new int[2];
    		intersection[0] = Math.max(A[0], B[0]);
    		intersection[1] = Math.min(A[1], B[1]);
    		list.add(intersection);
    	}
    	
    	int[][] res = new int[list.size()][2];
    	for (int i = 0; i < list.size(); i++)
    		res[i] = list.get(i);
    	
    	return res;
    }
}
