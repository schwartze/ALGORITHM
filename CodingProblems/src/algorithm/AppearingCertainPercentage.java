package algorithm;

public class AppearingCertainPercentage {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
		AppearingCertainPercentage acp = new AppearingCertainPercentage();
		int res = acp.findSpecialInteger(arr);
		System.out.println(res);
	}
	
	// return the integer which occurs more than 25% of the time
    public int findSpecialInteger(int[] arr) {
    	int specialTimes = (int) Math.ceil(arr.length * 0.25);
    	int res = 0;
    	
    	if (arr.length < 2)
    		res = arr[0];

    	for (int i = 0; i < arr.length && i + specialTimes < arr.length; i++) {
    		
    		if (arr[i] == arr[i + specialTimes])
    			res = arr[i];
    	}
    	return res;
    }
}
