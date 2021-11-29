package algorithm;

public class ReverseInteger {
	
	public static void main(String[] args) {
		int x = 123;
		int x2 = -123;
		int x3 = 120;
		
		int res = reverse(x3);
		System.out.println(res);
	}
	
	public static int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		int num = Math.abs(x);
		
		while (true) {
			int mod = num % 10;
			sb.append(mod);
			num /= 10;
			
			if (num < 10) {
				sb.append(num);
				break;
			}
		}
		return x > 0 ? Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString()) * -1;
    }
    
}
