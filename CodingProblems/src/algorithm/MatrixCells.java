package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MatrixCells {

	public static void main(String[] args) {
		int R = 2, C = 2, r0 = 0, c0 = 1;
		
		MatrixCells mCells = new MatrixCells();
		int[][] res = mCells.allCellsDistOrder(R, C, r0, c0);
		
	}
	
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    	int[][] res = new int[R * C][2];
    	Queue<Integer> queue = new LinkedList<>();

    	return res;
    }
}
