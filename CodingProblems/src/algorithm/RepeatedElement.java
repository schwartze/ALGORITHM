package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RepeatedElement {

	public static void main(String[] args) {
		int[] A = {5, 1, 5, 2, 5, 3, 5, 4};
		
		RepeatedElement rElement = new RepeatedElement();
		int res = rElement.repeatedNTimes(A);
		System.out.println(res);
	}
	
	/*
	 * In a array A of size 2N, there are N+1 unique elements, 
	 * and exactly one of these elements is repeated N times.
	 * Return the element repeated N times.
	 */
    public int repeatedNTimes(int[] A) {

    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int n : A) {
    		int count = map.getOrDefault(n, 0);
    		map.put(n, count + 1);
    	}
    	
    	for (int key : map.keySet()) 
    		if (map.get(key) == A.length / 2)
    			return key;
    	
    	return 0;
    }
}
