package algorithm;

public class NumberOfTeams {
	
	public static void main(String[] args) {
		int[] rating = {13, 3, 4, 10, 7, 8};
		
		int res = numTeams(rating);
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
	
	public static int numTeams(int[] rating) {
		int result = 0;
		
		for (int i = 1; i < rating.length - 1; i++) {

			// number smaller than i on left side * number greater than i on right side 
			// number greater than i on left side * number smaller than i on right side
			int leftSmaller = 0, leftGreater = 0, rightSmaller = 0, rightGreater = 0;
			
			for (int j = 0; j < i; j++) {
				if (rating[i] > rating[j]) {
					leftSmaller++;
				} else {
					leftGreater++;
				}
			}
			
			for (int k = i + 1; k < rating.length; k++) {
				if (rating[i] > rating[k]) {
					rightSmaller++;
				} else {
					rightGreater++;
				}
			}
			result += leftSmaller * rightGreater + leftGreater * rightSmaller;
		}
		return result;
	}
	
}
