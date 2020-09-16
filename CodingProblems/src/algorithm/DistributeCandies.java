package algorithm;

public class DistributeCandies {

	public static void main(String[] args) {
		int candies = 10, num_people = 3;
		DistributeCandies dCandies = new DistributeCandies();
		int[] res = dCandies.distributeCandies(candies, num_people);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
	// Return the array containing information about 
	// how many of candies each position of a person will get
    public int[] distributeCandies(int candies, int num_people) {
    	int[] res = new int[num_people];
    	int remainingCandies = candies;
    	int currentCandies = 1;
    	int idx = 0;
    	
    	while (remainingCandies > 0) {
    		
     		res[idx] += Math.min(remainingCandies, currentCandies);
     		remainingCandies -= currentCandies;
    		currentCandies++;
     		idx++;
     		
     		if (idx >= num_people)
     			idx = 0;
    	}
    	
    	return res;
    }

}
