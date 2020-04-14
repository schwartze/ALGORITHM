package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MatrixReshaper {

	public int[][] reshapeMatrix(int[][] nums, int r, int c) {
		
		List<Integer> temp = new ArrayList<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			for (int j = 0; j < nums[i].length; j++) {
				temp.add(nums[i][j]);
			}
		}
		
		if (temp.size() < r * c)
			return nums;
		
		int[][] result = new int[r][c];
		int k = 0;
		
		for (int i = 0; i < result.length; i++) {
			
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = temp.get(k);
				k++;
			}
		}
		
		return result;
	}
}
