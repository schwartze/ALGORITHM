package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	
	public static void main(String[] args) {
		Combinations combo = new Combinations();
		List<List<Integer>> res = combo.combine(1, 1);
		
		for (List<Integer> list : res) {
			for (int n : list)
				System.out.print(n + ", ");
			System.out.println();
		}
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	dfs(result, new ArrayList<>(), n, k, 1);
    	return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int k, int idx) {
    	if (list.size() == k) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	
    	for (int i = idx; i < n + 1; i++) {
    		list.add(i);
    		dfs(result, list, n, k, i + 1);
    		list.remove(list.size() - 1);
    	}
    }
}
