package algorithm;

import java.util.HashSet;

public class CandyDistributor {

	public static void main(String[] args) {
		int[] candies = {1, 1, 2, 2, 3, 3};
		CandyDistributor distributor = new CandyDistributor();
		int result = distributor.distributeCandies(candies);
		System.out.println(result);
	}
	/*
	 * Given an integer array with even length, 
	 * where different numbers in this array represent different kinds of candies. 
	 * Each number means one candy of the corresponding kind. 
	 * You need to distribute these candies equally in number to brother and sister. 
	 * Return the maximum number of kinds of candies the sister could gain.
	 */
	public int distributeCandies(int[] candies) {
		
		HashSet<Integer> set = new HashSet<>();
		
		for (int n : candies) {
			set.add(n);
		}
		
		return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
	}
	
}
