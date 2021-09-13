package algorithm;

public class MaxNumberOfBalloons {

	public static void main(String[] args) {
		String text = "nlaebolko";
		String text2 = "loonbalxballpoon";
		
		int res = maxNumberOfBalloons(text2);
		System.out.println(res);
	}
	
    public static int maxNumberOfBalloons(String text) {
    	int[] balloonArr = new int[26];
    	int max = Integer.MAX_VALUE;
    	
    	for (char c : text.toCharArray()) 
    		balloonArr[c - 'a']++;
    	
    	for (int n : balloonArr) 
    		if (text.indexOf((char)(n + 97)) >= 0 && max > balloonArr[n])
    			max = balloonArr[n];
    	
    	return max;
    }
}
