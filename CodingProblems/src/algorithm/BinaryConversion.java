package algorithm;

public class BinaryConversion {

	public static void main(String[] args) {
		String s = "01110";
		
		BinaryConversion bConversion = new BinaryConversion();
		int[] answer = bConversion.solution(s);
		
		for (int n : answer)
			System.out.print(n + ", ");
	}
	
    public int[] solution(String s) {
        int[] answer = new int[2];
        helper(s, answer);
        return answer;
    }
    
    private void helper(String s, int[] answer) {
    	int bitCount = getBitCount(s);
    	answer[0]++;
    	answer[1] += s.length() - bitCount;
    	
    	String bitStr = Integer.toBinaryString(bitCount);
    	if (bitStr.equals("1"))
    		return;
    	
    	helper(bitStr, answer);
    }
    
    private int getBitCount(String s) {
    	int bitCount = 0;
    	
    	for (char c : s.toCharArray())
    		if (c == '1')
    			bitCount++;
    	
    	return bitCount;
    }
}
