package algorithm;

public class Base7 {

	public static void main(String[] args) {
		Base7 base7 = new Base7();
		String result = base7.convertToBase7(-7);
		System.out.println(result);
	}
	
	public String convertToBase7(int num) {
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			
			int value = num / 7;
			int remainder = num % 7;
			num = value;
			
			sb.append(remainder);
			
			if (value < 7) {
				sb.append(Math.abs(value));
				break;
			}
		}

		if (num < 0)
			return sb.append("-").reverse().toString();
		else 
			return sb.reverse().toString();
	}
}
