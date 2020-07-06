package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

	public static void main(String[] args) {
		int[] input = {5, 5, 10, 10, 20};
		int[] bills = {5, 5, 10, 10, 20};

		LemonadeChange lChange = new LemonadeChange();
		boolean res = lChange.lemonadeChange(input);
		System.out.println(res);
	}
	
	// only takes $5, $10 or $20 bills 
    public boolean lemonadeChange(int[] bills) {
    	Map<Integer, Integer> billsMap = new HashMap<>();
    	
    	for (int bill : bills) {

    		if (bill == 10) {
    			int change = bill - 5;
    			if (billsMap.get(change) == null || billsMap.get(change) <= 0)
    				return false;
    			billsMap.put(change, billsMap.get(change) - 1);
    		}
    		
    		if (bill == 20) {
    			if (billsMap.get(5) == null || billsMap.get(5) <= 0)
    				return false;
    			if (billsMap.get(10) == null || billsMap.get(10) <= 0)
    				return false;
    			billsMap.put(5, billsMap.get(5) - 1);
    			billsMap.put(10, billsMap.get(10) - 1);
    		}

    		int count = billsMap.getOrDefault(bill, 0);
    		billsMap.put(bill, count + 1);
    	}
    	return true;
    }
}
