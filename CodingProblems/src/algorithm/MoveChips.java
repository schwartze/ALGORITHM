package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MoveChips {

	public static void main(String[] args) {
		int[] position = {1, 1000000000}; // 1
		int[] position2 = {2, 2, 2, 3, 3}; // 2 
		int[] position3 = {1, 2, 3}; // 1
		int[] position4 = {3, 3, 1, 2, 2}; // 2
		int[] position5 = {10,3,3,1,6,2,1,10,6,6}; // 4
		int[] position6 = {6,4,7,8,2,10,2,7,9,7}; // 4
		
		int res = minCostToMoveChips(position3);
		System.out.println(res);
	}
	
    public static int minCostToMoveChips(int[] position) {
		int odd = 0, even = 0;
		
		for (int idx : position) {
			if (idx % 2 == 0)
				even++;
			else 
				odd++;
		}
		return even > odd ? odd : even;
    }
}
