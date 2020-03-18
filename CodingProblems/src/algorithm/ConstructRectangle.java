package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConstructRectangle {

	public static void main(String[] args) {
		
		ConstructRectangle theRectangle = new ConstructRectangle();
		int[] result = theRectangle.constrcutrRectangle(4);
		
		for (int n : result)
			System.out.print(n + ", ");
	}
	/*
	 *  1. The area of the rectangular web page you designed must equal to the given target area.
	 *
	 *	2. The width W should not be larger than the length L, which means L >= W.
	 *	
	 *	3. The difference between length L and width W should be as small as possible.
	 */
	public int[] constrcutrRectangle(int num) {
		
		List<Integer> list = new ArrayList<>();
		List<Integer> diff = new ArrayList<>();
		
		int index = 1;
		
		while (index <= Math.sqrt(num)) {
			
			if (num % index == 0) {
				list.add(index);
				index++;
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			
			int width = list.get(i);
			int length = num / width;
			
			diff.add(length - width);
		}
		
		int j = 0;
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < diff.size(); i++) {
			
			if (diff.get(i) < min) 
				min = diff.get(i);
			
		}
		j = diff.indexOf((int)min);
		
		return new int[] {num / list.get(j), list.get(j)};
	}

	
	public int[] constructRectangle2(int area) {
		
		int width = (int)Math.sqrt(area);
		
		while (area % width != 0)
			width--;
		
		return new int[] {area / width, width};
	}

}
