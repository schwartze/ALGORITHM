package algorithm;

import java.util.TreeMap;

public class LuckyInArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 3, 3};
		int res = findLucky(arr);
		System.out.println(res);
	}
	
	// Return the lucky number in the array 
	// when lucky number is defined as a number which occurs the same times as its number
	// if there are more than 2 lucky numbers, return the largest number out of all
    public static int findLucky(int[] arr) {
    	TreeMap<Integer, Integer> numMap = new TreeMap<>();
    	int res = -1;
    	
    	for (int n : arr)
    		numMap.put(n, numMap.getOrDefault(n, 0) + 1);
    	
    	for (int key : numMap.descendingKeySet()) {
    		if (key == numMap.get(key)) {
    			res = key;
    			break;
    		}
    	}
    	
    	return res;
    }
}
