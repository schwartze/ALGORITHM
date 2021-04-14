package algorithm;

public class BeautyScore {

	public static void main(String[] args) {
		String s = "baby";
		
		BeautyScore bScore = new BeautyScore();
		long res = bScore.solution(s);
		System.out.println(res);
	}
	
    public long solution(String s) {
        long answer = 0;
        
        for (int i = 0; i < s.length() - 1; i++)
        	answer += getMaxScore(s, i);
        
        return answer;
    }
    
    private int getMaxScore(String s, int idx) {
    	int max = 0;
    	
    	for (int i = idx + 1; i < s.length(); i++) {
    		max += getScore(s, idx, i);
    	}
    	
    	return max;
    }
    
    private int getScore(String s, int startIdx, int endIdx) {
    	int max = 0;
    	
    	while (startIdx < endIdx) {
    		int i;
    		
    		for (i = endIdx; i >= startIdx; i--) 
    			if (s.charAt(i) != s.charAt(startIdx))
    				break;
    		max = Math.max(max, i - startIdx);
    		startIdx++;
    	}
    	
    	return max;
    }
}
