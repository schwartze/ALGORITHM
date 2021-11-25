package algorithm;

import java.util.ArrayList;
import java.util.List;

public class KthString {
	
	public static void main(String[] args) {
		String res = getHappyString(10, 100);
		System.out.println(res);
	}
	
    public static String getHappyString(int n, int k) {
    	List<String> list = new ArrayList<>();
    	dfs(list, new StringBuilder(), n, 0);
    	
    	return k > list.size() ? "" : list.get(k - 1);
    }
    
    private static void dfs(List<String> list, StringBuilder sb, int n, int idx) {
    	if (sb.length() == n) {
    		list.add(sb.toString());
    		return;
    	}
    	String given = "abc";
    	for (int i = 0; i < given.length(); i++) {
    		
    		if (sb.length() == 0 || sb.charAt(sb.length() - 1) != given.charAt(i)) {
    			sb.append(given.charAt(i));
    			dfs(list, sb, n, idx + 1);
    			sb.deleteCharAt(sb.length() - 1);
    		}
    	}
    }
}
