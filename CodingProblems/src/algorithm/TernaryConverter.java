package algorithm;

public class TernaryConverter {
	
	public static void main(String[] args) {
		int n = 45;
		int res = solution(n);
		System.out.println(res);
	}

    public static int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        while (n >= 3) {
        	int mod = n % 3;
        	sb.append(mod);
        	n /= 3;
        }
    	sb.append(n);

    	for (int i = sb.length() - 1, j = 0; i >= 0; i--, j++) {
    		answer += Integer.parseInt(sb.charAt(i) + "") * Math.pow(3, j);
    	}
        
        return answer;
    }
}
