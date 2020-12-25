package algorithm;

public class LargestNumber {

	public static void main(String[] args) {
		String number = "4177252841";
		String k ="4";
		
		String number2 = "1924";
		String k2 ="2";
		
		String number3 = "1231234";
		String k3 ="3";
		
		String number4 = "123456789123456789123456789456789123456789123456789456123456789123456789123456789";
		String k4 ="70";
		// 99999999789
		
		String res = getLargestNumber(number, k);
		System.out.println(res);
		System.out.println(number4.length());
	} 
	
	public static String getLargestNumber(String number, String k) {
		int i = 0, max = 0, maxIdx = 0, toRemove = Integer.parseInt(k);
		
		while (i + toRemove < number.length()) {
			if (max == 9)
				break;
			
			if (Integer.parseInt(number.charAt(i) + "") > max && toRemove > i) {
				max = Integer.parseInt(number.charAt(i) + "");
				maxIdx =  i;
			}
			i++;
		}
		toRemove -= maxIdx;
		StringBuilder sb = new StringBuilder(number.substring(maxIdx, number.length()));
		int start = 1;
		
		while (toRemove > 0) {
			int rangeMin = 10, rangeIdx = 0, j;
			
			for (j = start; j <= start + toRemove && j < sb.length(); j++) {
				if (rangeMin == 1)
					break;
				
				if (Integer.parseInt(sb.charAt(j) + "") < rangeMin) {
					rangeMin = Integer.parseInt(sb.charAt(j) + "");
					rangeIdx = j;
				}
			}
			sb.deleteCharAt(rangeIdx);
			start = rangeIdx;
			toRemove--;
			
			if (toRemove > 0 && j >= sb.length())
				start = 1;
		}
		return sb.toString();
	}
}
