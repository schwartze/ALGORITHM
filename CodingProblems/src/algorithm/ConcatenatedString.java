package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedString {
	
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("un","iq","ue");
		
		ConcatenatedString cString = new ConcatenatedString();
		int res = cString.maxLength(arr);
		System.out.println(res);
	}
	
    public int maxLength(List<String> arr) {
    	int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
    	
    	for (String str : arr) {
    		if (str.length() > max) {
    			secondMax = max;
    			max = str.length();
    		} else if (str.length() > secondMax) {
    			secondMax = str.length();
    		}
    	}
    	
    	return max + secondMax;
    }
    
}
