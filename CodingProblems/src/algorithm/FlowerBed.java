package algorithm;

import java.util.HashSet;

public class FlowerBed {

	public static void main(String[] args) {
		int[] floorbed = {1, 0, 0, 0, 1};
		
		FlowerBed fBed = new FlowerBed();
		boolean result = fBed.canPlaceFloor(floorbed, 2);
		System.out.println(result);
	}
	
	// find if one can place n number of floor on the given floorbed
	// Note that one cannot place a floor right next to the floor 
	// there at least needs to have an empty space 
		// right next to the floor when placing a new floor 
	public boolean canPlaceFloor(int[] floorbed, int n) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < floorbed.length; i++) {
		
			if (floorbed[i] == 0)
				set.add(i);
		}
		int count = 0;
		
		for (int i : set) {
			
			if (floorbed[i - 1] == 1 || floorbed[i + 1] == 1) {
				count++;
			}
		}
		
		return count > n ;
	}
}
