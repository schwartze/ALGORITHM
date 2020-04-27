package algorithm;

import java.util.HashSet;

public class FlowerBed {

	public static void main(String[] args) {
		int[] flowerbed = {1, 0, 0, 0, 0, 1};
		
		FlowerBed fBed = new FlowerBed();
		boolean result = fBed.canPlaceFlower(flowerbed, 2);
		System.out.println(result);
	}
	
	// find if one can place n number of flower on the given flowerbed
	// Note that one cannot place a flower right next to the flower 
	// there at least needs to have an empty space 
		// right next to the flower when placing a new flower 
	public boolean canPlaceFlower(int[] flowerbed, int n) {
		
		int count = 0, i = 0;
		
		while (i < flowerbed.length) {
			// for 0th array, does not have to check i - 1
			// for (arr.length - 1)th array, does not have to check i + 1
			if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && 
					(flowerbed.length - 1 == i || flowerbed[i + 1] == 0)) {
				flowerbed[i] = 1;
				count++;
			}
			i++;
		}
	
		return count >= n;
	}
}
