package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LargestPerimeter {

	public static void main(String[] args) {
		int[] A = {
				741543,812711,204837,321987,64537,878008,221451,327106,519590,632854,258421,777138,648326,163607,970976,160711,832045,458756,21938,914098,835982,430595,342469,265138,225707,494713,495327,112759,147046,115957,385779,852227,452239,508931,825955,438955,71058,49515,379521,239031,124516,197904,520779,309104,220997,17259,834188,589665,971314,723219,738549,348958,18166,494987,445213,202268,65738,575195,142499,720795,857949,241693,964781,288878,355721,149425,569030,128272,250882,766638,781278,954830,202897,499908,242161,836044,882445,149046,973168,308861,695969,397252,694236,786512,225385,758712,575288,903009,777254,312041,90724,997241,199369,901039,976660,433213,47420,768493,3320,666795,996456,436528,122410,47092,648548,57669,390447,297586,355856,968592,522598,278337,961624,893997,738786,548212,48845,344374,666675,86626,613747,825657,259026,279646,976958,973717,576245,18265,834727,889977,196365,712752,654079,575652,921270,333401,212866,952770,876057,898947,338716,540373,494868,650588,500175
				};
	
		LargestPerimeter triangle = new LargestPerimeter();
		int res = triangle.largestPerimeter2(A);
		System.out.println(res);
	}
	
    public int largestPerimeter(int[] A) {
    	int maxPerimeter = 0;
    	Set<Integer> set = new HashSet<>();
    	
    	for (int i = 0; i < A.length; i++) {
    		int a = A[i];

        	for (int j = 0; j < A.length; j++) {
    			if (j == i)
    				continue;
    			
    			int b = A[j];
            	for (int k = 0; k < A.length; k++) {
    				if (k == j || k == i)
    					continue;
    				
    				int c = A[k];
    				if (canMakeATriangle(a, b, c) && !set.contains(a + b + c)) {
    					set.add(a + b + c);
    					maxPerimeter = Math.max(maxPerimeter, a + b + c);
    				}
    			}
    		}
    	}
    	return maxPerimeter;
    }
    
    private boolean canMakeATriangle(int a, int b, int c) {
    	
    	if (a + b <= c)
    		return false;
    	
    	if (a + c <= b)
    		return false;
    	
    	if (b + c <= a)
    		return false;
    	
    	return true;
    }
    
    
    public int largestPerimeter2(int[] A) {
    	
    	// #1. To find the largest perimeter: a <= b <= c
    	// #2. It has to form a triangle: a + b > c 
    	
    	for (int i = A.length - 3; i >= 0; i--) 
    		if (A[i] + A[i + 1] > A[i + 2])
    			return A[i] + A[i + 1] + A[i + 2];
    	
    	return 0;
    }
}
