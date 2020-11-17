package algorithm;

import java.util.ArrayList;
import java.util.List;

public class KidsWithCandies {

	public static void main(String[] args) {
		int[] candies = {12, 1, 12};
		int extraCandies = 10;
		List<Boolean> res = kidsWithCandies(candies, extraCandies);
		
		for (boolean canBeGreatest : res)
			System.out.println(canBeGreatest);
	}
	// Each element of given integer array candies represents how many candies ith kid has
	// Return an array of boolean representing if ith kid can have the grestest number of candies out of all 
	// after adding the given extraCandies 
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    	List<Boolean> res = new ArrayList<>(candies.length);
    	int max = 0;
    	
    	for (int candy : candies)
    		max = Math.max(max, candy);
    	
    	for (int candy : candies) 
			res.add(candy + extraCandies >= max);
    	
    	return res;
    }
}
