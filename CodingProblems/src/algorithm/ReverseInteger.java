package algorithm;

public class ReverseInteger {
	
	public static void main(String[] args) {
		int x = 123;
		int x2 = -123;
		int x3 = 120;
		int x4 = -2147483648;
		
		int res = reverse(x4);
		System.out.println(res);
	}
	
	public static int reverse(int x) {
		long num = Math.abs((long)x);
		if (Long.toString(num).length() < 2) {
			return x;
		}
		
		StringBuilder sb = new StringBuilder();
		while (true) {
			long mod = num % 10;
			sb.append(mod);
			num /= 10;
			
			if (num < 10) {
				sb.append(num);
				break;
			}
		}
		
		long reversedNum = x > 0 ? Long.parseLong(sb.toString()) : Long.parseLong(sb.toString()) * -1;
		if (reversedNum > (long)Integer.MAX_VALUE || reversedNum < (long)Integer.MIN_VALUE)
			return 0;

		return (int)reversedNum;
    }
}
