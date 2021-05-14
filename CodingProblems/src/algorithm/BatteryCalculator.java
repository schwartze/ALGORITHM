package algorithm;

public class BatteryCalculator {

	public static void main(String[] args) {
		int n = 5000;
		
		int res = solution(n);
		System.out.println(res);
	}
	
    public static int solution(int n) {
        int ans = 0;
        
        while (n > 0) {
        	if (n % 2 == 0) {
        		n /= 2;
        	}
        	else {
        		ans++;
        		n--;
        	}
        }
        
        return ans;
    }

}
