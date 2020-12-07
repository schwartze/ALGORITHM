package algorithm;

public class OddNumbers {

	public static void main(String[] args) {
		int low = 14, high = 17;
		int res = countOdds(low, high);
		System.out.println(res);
	}
	
    public static int countOdds(int low, int high) {
    	int count = 0;
    	
    	while (low <= high) {
    		if (low % 2 != 0) 
    			count++;
    		low++;
    	}
    	return count;
    }
    
    public static int countOdds2(int low, int high) {	
    	return low % 2 == 0 ? (high - low) / 2 : (high - low) / 2 + 1;
    }
}
