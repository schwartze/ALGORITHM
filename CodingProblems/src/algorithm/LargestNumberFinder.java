package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFinder {
	
	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		LargestNumberFinder largestNumFinder = new LargestNumberFinder();
		String res = largestNumFinder.getLargestNum(numbers);
		System.out.println(res);
	}
	
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
    
    public String getLargestNum(int[] numbers) {
    	Integer[] arr = new Integer[numbers.length];
    	
    	for (int i = 0; i < numbers.length; i++)
    		arr[i] = numbers[i];
    	
    	Arrays.sort(arr, new NumberComparator());
    	StringBuilder sb = new StringBuilder();
    	
    	for (int n : arr)
    		sb.append(n);
    	
    	return sb.toString();
    }
    
    class NumberComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer n1, Integer n2) {
			
			if (n1 < 10 && n2 < 10)
				return n2 - n1;

			int n1Digit = getDigit(n1);
			int n2Digit = getDigit(n2);
			
			int minDigit = n1Digit > n2Digit ? n2Digit : n1Digit;
			int idx = 0, max = 0;
			
			while (minDigit-- > 0) {
				int numInTargetDigit1 = getNum(n1, idx);
				int numInTargetDigit2 = getNum(n2, idx);
				
				if (numInTargetDigit1 != numInTargetDigit2) {
					max = numInTargetDigit1 > numInTargetDigit2 ? n1 : n2;
					break;
				}
				
				if (numInTargetDigit1 < 0 || numInTargetDigit2 < 0) {
					max = numInTargetDigit1 < 0 ? n1 : n2;
					break;
				}
				idx++;
			}
			
			return max == n1 ? -1 : 1;
		}
		
		private int getNum(int num, int idx) {
			String numStr = Integer.toString(num);
			
			if (numStr.length() < idx)
				return -1;
			
			String targetNumStr = numStr.charAt(idx) + "";
			return Integer.parseInt(targetNumStr);
		}
		
		private int getDigit(int num) {
			int digit = 0;
			
			while (num > 0) {
				num /= 10;
				digit++;
			}
			
			return digit;
		}

    }
    
   
}
