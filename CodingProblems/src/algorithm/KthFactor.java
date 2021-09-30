package algorithm;

import java.util.ArrayList;
import java.util.List;

public class KthFactor {
	
	public static void main(String[] args) {
		int n = 1000, k = 3;
		
		int res = kthFactor(n, k);
		System.out.println(res);
	}

    public static int kthFactor(int n, int k) {
    	List<Integer> list1 = new ArrayList<>();
    	List<Integer> list2 = new ArrayList<>();
    	int i = 1;
    	
    	list1.add(i++);
    	list2.add(n);
    	
    	while (list1.get(list1.size() - 1) < list2.get(list2.size() - 1)) {
    		
    		if (n % i == 0) {
    			list1.add(i);
    			list2.add(n / i);
    		}
    		i++;
    		
    		if (list1.size() >= k) {
    			return list1.get(k - 1);
    		}
    	}
    	
    	return list2.get(list2.size() - list1.size() - k);
    }
    
}
