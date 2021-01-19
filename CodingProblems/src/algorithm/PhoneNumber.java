package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class PhoneNumber {

	public static void main(String[] args) {
		String number = "1-23-45 6";
		String number2 = "123 4-567";
		String number3 = "123 4-5678";
		String number4 = "12";
		String number5 = "--17-5 229 35-39475 ";
		String number6 = "9964-";
		
		String res = reformatNumber(number6);
		System.out.println(res);
	}
	// 2 digits: A single block of length 2.
	// 3 digits: A single block of length 3.
	// 4 digits: Two blocks of length 2 each.
    public static String reformatNumber(String number) {
    	Queue<Character> queue = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	
    	for (char num : number.toCharArray()) 
    		if (num >= 48 && num <= 57)
    			queue.offer(num);

    	int cnt = 0;
    	while (!queue.isEmpty()) {
    		sb.append(queue.poll());
    		cnt++;
    		
    		if (cnt == 3 && !queue.isEmpty()) {
    			cnt = 0;
    			sb.append("-");
    		}
    	}
    	
    	if (sb.lastIndexOf("-") == sb.length() - 2) {
    		sb.insert(sb.lastIndexOf("-") - 1, "-");
    		sb.deleteCharAt(sb.lastIndexOf("-"));
    	}
    	
    	return sb.toString();
    }
}
