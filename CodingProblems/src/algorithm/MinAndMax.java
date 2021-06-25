package algorithm;

import java.util.Arrays;

public class MinAndMax {
	
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		String res = solution(s);
		System.out.println(res);
	}
	
    public static String solution(String s) {
        String[] sArr = s.split(" ");
        Arrays.sort(sArr, (a, b) -> Integer.parseInt((String)a) - Integer.parseInt((String)b));
        
        return sArr[0] + " " + sArr[sArr.length - 1];
    }
}
