package algorithm;

public class SpecialFunction {

	public static void main(String[] args) {
		long num = 7;
		
		 long res = getMinNumberWithDifferentBits(num);
		 System.out.println(res);
		
		// System.out.println(Long.bitCount(num ^ (num + 1)));
	}
	// return the array of numbers in which each value is greater then the number in the same index of given array 
	// and its bit has 1 or 2 value different from the original number 
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
        	answer[i] = getMinNumberWithDifferentBits(numbers[i]);
        }
        
        return answer;
    }
    
    private static long getMinNumberWithDifferentBits(long num) {
    	long diffBitCount = 3;
    	long result = num;
    	
    	while (diffBitCount > 2) {
    		result++;
    		diffBitCount = Long.bitCount(num ^ result);
    	}
    	return result;
    }
}
