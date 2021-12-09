package algorithm;

public class PositiveNegative {

	public static void main(String[] args) {
		int[] absolutes = {4, 7, 12};
		boolean[] signs = {true, false, true};
		
		int[] absolutes2 = {1, 2, 3};
		boolean[] signs2 = {false, false, true};
		
		
		int res = solution(absolutes2, signs2);
		System.out.println(res);
	}
	
    public static int solution(int[] absolutes, boolean[] signs) {
    	int answer = 0;
    	
    	for (int i = 0; i < absolutes.length; i++) {
    		if (!signs[i]) {
    			answer -= absolutes[i];
    		} else {
    			answer += absolutes[i];
    		}
    	}
    	
        return answer;
    }
}
