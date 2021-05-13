package algorithm;

public class RangeSumCalculator {

	public static void main(String[] args) {
		int left = 13, right = 17;
		
		int res = solution(left, right);
		System.out.println(res);
	}
	
    public static int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i < right + 1; i++) {
        	int factorCnt = getFactorCount(i);
        	if (factorCnt % 2 == 0) 
        		answer += i;
        	else 
        		answer -= i;
        }
        return answer;
    }
    
    private static int getFactorCount(int num) {
    	int count = 0, temp = 1;
    	
    	while (temp <= num) {
    		if (num % temp == 0)
    			count++;
    		temp++;
    	}
    	
    	return count;
    }
}
