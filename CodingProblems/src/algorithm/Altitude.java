package algorithm;

public class Altitude {

	public static void main(String[] args) {
		int[] gain = {-4, -3, -2, -1, 4, 3, 2};
		int[] gain2 = {-5, 1, 5, 0, -7};
		
		int res = largestAltitude(gain2);
		System.out.println(res);
	}
	
    public static int largestAltitude(int[] gain) {
    	int largest = 0;
    	int[] altitudes = new int[gain.length + 1];
    	
    	for (int i = 0; i < gain.length; i++) {
    		altitudes[i + 1] = altitudes[i] + gain[i];
    		
    		if (altitudes[i + 1] > largest)
    			largest = altitudes[i + 1];
    	}
    	return largest;
    }
}
