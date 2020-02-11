package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] arr1 = {4, 9, 5};
		int[] arr2 = {9, 4, 9, 8, 4};
		
		int[] result = getIntersection(arr1, arr2);

		int[] result2 = intersection(arr1, arr2);
	
		for (int i = 0; i < result2.length; i++) {
			System.out.println(result2[i]);
		}
	}
	
	public static int[] getIntersection(int[] arr1, int[] arr2) {
		HashSet<Integer> set = new HashSet<>();	

		for (int i = 0; i < arr1.length; i++) {
			
			for (int j = 0; j < arr2.length; j++) {
				
				if (arr1[i] == arr2[j])
					set.add(arr1[i]);
			}
		}
		
		int[] result = new int[set.size()];
		
		Iterator<Integer> value = set.iterator();
		
		for (int i = 0; i < set.size(); i++) {
			result[i] = (int)value.next();
		}

		return result;
	}
	
	// #2: having two sets
	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for (Integer n : nums1)
			set1.add(n);
		
		for (Integer n : nums2)
			set2.add(n);
		
		if (set1.size() < set2.size())
			return helper(set1, set2);
		else 
			return helper(set2, set1);
	}
	
	private static int[] helper(HashSet<Integer> set1, HashSet<Integer> set2) {
		int[] result = new int[set1.size()];
		
		int index = 0;
		
		// iterate over a shorter set
		for (int n : set1)
		
			if (set2.contains(n))
				result[index++] = n;
		
		return Arrays.copyOf(result, index);
	}
	
	// #3: using Java set built-in method retailAll()
	public int[] intersection2(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for (Integer n : nums1)
			set1.add(n);
		
		for (Integer n : nums2)
			set2.add(n);
		
		// remove all elements in set1 that are not in set2
		set1.retainAll(set2);
		
		int[] output = new int[set1.size()];
		
		int index = 0;
		for (int n : set1)
			output[index++] = n;
		
		return output;
	}
}
