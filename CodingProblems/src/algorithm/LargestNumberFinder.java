package algorithm;

public class LargestNumberFinder {
	
    public static String getLargestNumber(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        
        while (flag) {
            int max = 0;
            boolean isContinue = !flag;
            for (int i = 0; i < numbers.length; i++) {
            	int temp = getMax(numbers[i], max);
            	
            	if (temp > max) {
            		max = temp;
            		isContinue = true;
            	}
            }
            sb.append(max);
            flag = isContinue;
        }
        
        return sb.toString();
    }
    
    private static int getMax(int a, int b) {
    	int n1 = a, n2 = b, max = 0;
    	
    	while (true) {
    		
    		int c = n1 > 10 ? n1 / 10 : n1 % 10;
    		int d = n2 > 10 ? n2 / 10 : n2 % 10;
    		
    		n1 = n1 > 10 ? n1 % 10 : 0;
    		n2 = n2 > 10 ? n2 % 10 : 0;
    		
    		max = c > d ? a : b;
    		
    		if (c != d) {
    			break;
    		}
    	}
    	
    	return max;
    }
}
