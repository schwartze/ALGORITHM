package algorithm;

public class SlowestKey {

	public static void main(String[] args) {
		int[] releaseTimes = {9, 29, 49, 50}; 
		String keysPressed = "cbcd";
		
		int[] releaseTimes2 = {12, 23, 36, 46, 62}; 
		String keysPressed2 = "spuda";
		
		int[] releaseTimes3 = {1, 2}; 
		String keysPressed3 = "ba";
		
		
		char res = slowestKey(releaseTimes, keysPressed);
		System.out.println(res);
	}
	// Return the key of the keypress that had the longest duration. 
	// If there are multiple such keypresses, return the lexicographically largest key of the keypresses.
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
    	int longest = releaseTimes[0];
    	int idx = 0;
    	
    	for (int i = 1; i < releaseTimes.length; i++) {
    		
    		if (releaseTimes[i] - releaseTimes[i - 1] > longest) {
    			longest = releaseTimes[i] - releaseTimes[i - 1];
    			idx = i;
    		}
    		
    		if (releaseTimes[i] - releaseTimes[i - 1] >= longest) {
    			idx = keysPressed.charAt(idx) > keysPressed.charAt(i) ? idx: i;
    		}
    	}
    	return keysPressed.charAt(idx);
    }
}
