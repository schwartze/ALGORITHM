package algorithm;

import java.util.Arrays;

public class AssignCookies {

	public static void main(String[] args) {
		int[] g = {1, 2, 3};
		int[] s = {1, 1};
		
		int[] g2 = {1, 2};
		int[] s2 = {1, 2, 3};
		
		int[] g3 = {1, 2, 3};
		int[] s3 = {3};

		int[] g4 = {10, 9, 8, 7};
		int[] s4 = {5, 6, 7, 8};

		
		int res = findContentChildren(g4, s4);
		System.out.println(res);
	}
	/*
	 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
	 * Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
	 */
    public static int findContentChildren(int[] g, int[] s) {
    	
    	if (s.length < 1)
    		return 0;
    	
    	Arrays.sort(g);
    	Arrays.sort(s);
    	
    	int j = s.length - 1, contentChildren = 0;
    	
    	for (int i = g.length - 1; i >= 0 && j >= 0; i--) {
    		
    		if (g[i] > s[j]) 
    			continue;
    		
    		contentChildren++;
    		j--;
    	}
    	return contentChildren;
    }
}