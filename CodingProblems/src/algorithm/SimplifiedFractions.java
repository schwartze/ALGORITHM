package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SimplifiedFractions {
	
	public static void main(String[] args) {
		int n = 4;
		
		simplifiedFractions(n).forEach(System.out::println);;
	
	}

    public static List<String> simplifiedFractions(int n) {
    	List<String> result = new ArrayList<>();
    	
    	for (int i = 2; i <= n; i++) {
    		
    		for (int j = 1; j <= n; j++) {
    			if ((j / i) >= 1 || i == j || hasCommonDenominator(i, j)) 
    				continue;
    			result.add(j + "/" + i);
    		}
    	}
    	
    	
    	return result;
    }
    
    private static boolean hasCommonDenominator(int val1, int val2) {
    	if (val1 == 1 || val2 == 1) return false;
    	int n = 1;
    	boolean canBeSimplified = false;
    	
    	while (n++ <= 100) {
    		
    		if (val1 % n == 0 && val2 % n == 0) {
    			canBeSimplified = true;
    			break;
    		}
    	}
    	
    	return canBeSimplified;
    }
}
