package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		generateParenthesis(3);
	}

    public static List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<>();
    	helper(list, "", 0, 0, n);
    	return list;
    }
    
    private static void helper(List<String> list, String str, int open, int close, int max) {
    	if (str.length() == max * 2) {
    		list.add(str);
    		return;
    	}
    	
    	if (open < max)
    		helper(list, str + "(", open + 1, close, max);
    	if (close < open)
    		helper(list, str + ")", open, close + 1, max);
    }
}
