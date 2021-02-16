package algorithm;

public class NumberOfTeams {
	
	public static void main(String[] args) {
		int[] rating = {2, 5, 3, 4, 1};
		
		int res = getNumberOfTeams(rating);
		System.out.println(res);
	}

	public static int getNumberOfTeams(int[] rating) {
		int result = 0;
		
		for (int i = 0; i < rating.length - 2; i++) {
			
			for (int j = i + 1; j < rating.length - 1; j++) {
				
				for (int k = j + 1; k < rating.length; k++) {
					
					if (rating[i] < rating[j] && rating[j] < rating[k])
						result++;
					
					if (rating[i] > rating[j] && rating[j] > rating[k])
						result++;
				}
			}
		}
		return result;
	}
	
}
