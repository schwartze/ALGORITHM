package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbers {
	
	public static void main(String[] args) {
		int[][] matrix = {
				{3, 7, 8},
				{9, 11, 13},
				{15, 16, 17}
		};
		
		int[][] matrix2 = {
				{1, 10, 4, 2},
				{9, 3, 8, 7}, 
				{15, 16, 17, 12}
		};
		
		List<Integer> res = luckyNumbers(matrix2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static List<Integer> luckyNumbers (int[][] matrix) {
    	List<Integer> res = new ArrayList<>();
    	Set<Integer> rowSet = new HashSet<>();
    	Set<Integer> columnSet = new HashSet<>();
    	
    	for (int i = 0; i < matrix.length; i++) {
    		int[] copiedArr = matrix[i].clone();
    		Arrays.sort(copiedArr);
    		rowSet.add(copiedArr[0]);
    	}
    	
    	for (int i = 0; i < matrix[0].length; i++) {
    		int[] tempArr = new int[matrix.length];
    		
    		for (int j = 0; j < matrix.length; j++) {
    			tempArr[j] = matrix[j][i];
    		}
    		Arrays.sort(tempArr);
    		columnSet.add(tempArr[tempArr.length - 1]);
    	}
    	
    	for (int key : rowSet)
    		if (columnSet.contains(key))
    			res.add(key);
    	
    	return res;
    }
}
