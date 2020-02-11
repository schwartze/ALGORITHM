package algorithm;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays2 {

	public static void main(String[] args) {
		int[] nums1 = {4, 9, 5};
		int[] nums2 = {9, 4, 9, 8, 4};
		
		int[] result = intersect2(nums1, nums2);
		
		for (int i = 0; i < result.length; i++) {
			
			System.out.print(result[i] + ", ");
		}
	}
	
	// #1: first try
    public static int[] intersect(int[] nums1, int[] nums2) {
     ArrayList<Integer> temp = new ArrayList<Integer>();
     
     for (int i = 0; i < nums1.length; i++) {
    	 
    	 for (int j = 0; j < nums2.length; j++) {
    		 
    		 if (nums1[i] == nums2[j]) {
    			 temp.add(nums1[i]);
    			 break;
    		 }
    	 }
     }

     int[] result = new int[temp.size()];

     for (int i = 0; i < temp.size(); i++) {
    	 result[i] = temp.get(i);
     }
     
     return result;
    }
    
    // #2: using map 
    public static int[] intersect2(int[] nums1, int[] nums2) {
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for (int n : nums1) {
    		int count = map.getOrDefault(n, 0);
    		map.put(n, count + 1);
    	}
    		
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for (int n : nums2) {
    		
    		if (map.get(n) != null && map.get(n) > 0) {
    			list.add(n);
    			map.put(n, map.get(n) - 1);
    		}
    	}
    	
    	int[] result = new int[list.size()];
    	
    	for (int i = 0; i < list.size(); i++) {
    		result[i] = list.get(i);
    	}
    	
    	return result;
    }
    
    // #3: an optimized method when two arrays are sorted
    public int[] findIntersectOfTwoSortedArrays(int[] nums1, int[] nums2) {

    	int n = nums1.length;
    	int m = nums2.length;
    	
    	int i = 0;
    	int j = 0;
    	ArrayList<Integer> list = new ArrayList<Integer>();

    	while (i < n && j < m) {
    		int a = nums1[i];
    		int b = nums2[j];
    		
    		if (a == b) {
    			list.add(a);
    			i++;
    			j++;
    		} else if (a < b) {
    			i++;
    		} else {
    			j++;
    		}
    	}

    	int[] result = new int[list.size()];
    	
    	for (int k = 0; k < list.size(); k++) {
    		result[k] = list.get(k);
    	}
    	
    	return result;
    }
}
