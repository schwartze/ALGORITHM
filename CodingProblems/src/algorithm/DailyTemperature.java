package algorithm;

public class DailyTemperature {

	public static void main(String[] args) {
		int[] temperatures = {73,74,75,71,69,72,76,73};
		int[] temperatures2 = {30, 40, 50, 60};
		int[] temperatures3 = {30, 60, 90};
		
		int[] res = dailyTemperatures(temperatures3);
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] dailyTemperatures(int[] temperatures) {
    	int[] res = new int[temperatures.length];
    	
    	for (int i = 0; i < temperatures.length; i++) {
    		int j = i + 1;
    		boolean hasWarmerDay = false;
    		
    		for (; j < temperatures.length; j++) {
    			if (temperatures[j] > temperatures[i]) {
        			hasWarmerDay = true;
    				break;
    			}
    		}
    		if (!hasWarmerDay) {
    			res[i] = 0;
    			continue;
    		}
    		res[i] = j - i;
    	}
    	
    	return res;
    }
}
