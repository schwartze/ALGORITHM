package algorithm;

import java.util.HashMap;
import java.util.Map;

public class ArrayFormation {

	public static void main(String[] args) {
		int[] arr = {91, 4, 64, 78};
		int[][] pieces = {{78}, {4, 64}, {91}};

		int[] arr2 = {1, 3, 5, 7};
		int[][] pieces2 = {{2, 4, 6, 8}};

		
		boolean res = canFormArray(arr, pieces);
		System.out.println(res);
	}
	
    public static boolean canFormArray(int[] arr, int[][] pieces) {
    	boolean result = true;
    	Map<Integer, Integer> map = new HashMap<>(pieces.length);
    	
    	for (int i = 0; i < pieces.length; i++) 
    		map.put(pieces[i][0], i);
    	
    	for (int i = 0; i < arr.length;) {
    		if (!map.containsKey(arr[i])) {
    			result = false;
    			break;
    		}
    		int[] piece = pieces[map.get(arr[i])];
    		for (int j = 0; j < piece.length; j++) {
    			if (arr[i] != piece[j]) {
    				result = false;
    				break;
    			}
    			i++;
    		}
    	}
    	return result;
    }
}
