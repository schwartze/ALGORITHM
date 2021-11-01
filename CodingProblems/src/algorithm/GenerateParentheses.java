package algorithm;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	
	public static void main(String[] args) {
		List<String> result = generateParenthesis(3);
		result.forEach(System.out::println);
	}
    
    public static List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
    	helper( result, "", 0, 0, n );
    	return result;
    }
    
    private static void helper( List<String> result, String str, int open, int close, int n ) {
    	
    	if ( open == n && close == n ) {
    		result.add( str );
    		return;
    	}
    	
    	if ( open < n ) {
    		helper( result, str + "(", open + 1, close, n );
    	}
    	
    	if ( open > close ) {
    		helper( result, str + ")", open, close + 1, n );
    	}
    }
}
