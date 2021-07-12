package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PascalTriagle {
	
	public static void main(String[] args) {
		int numRows = 1;
		
		List<List<Integer>> res = generate(numRows);
		
		for (List<Integer> nums : res) {
			for (int n : nums) {
				System.out.print(n + ", ");
			}
			System.out.println();
		}
		
	}
	
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> triangle = new ArrayList<List<Integer>>();
    	
    	for (int i = 0; i < numRows; i++) {
    		List<Integer> list = new ArrayList<>();
    		
    		if (i == 0) {
    			list.add(1);
    			triangle.add(list);
    			continue;
    		}
    		
    		if (i == 1) {
    			list.add(1);
    			list.add(1);
    			triangle.add(list);
    			continue;
    		}
    		
    		for (int j = 0; j <= i; j++) {
    			
    			if (j != 0 && j != i) {
    				int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
    				list.add(sum);
    				continue;
    			}
    			list.add(1);
    		}
    		triangle.add(list);
    	}
    	
    	return triangle;
    }
}
