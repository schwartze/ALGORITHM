package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavoriteRestaurant {

	public static void main(String[] args) {
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Shogun", "Burger King"};
		
		FavoriteRestaurant favRes = new FavoriteRestaurant();
		String[] res = favRes.findRestaurant(list1, list2);

		for (String str : res) 
			System.out.println(str);
	}
	
    public String[] findRestaurant(String[] list1, String[] list2) {
     
    	String[] result = new String[1];
    	int minIndexSum = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < list1.length; i++) {
    		
    		for (int j = 0; j < list2.length; j++) {
    			
    			if (list1[i].equals(list2[j]) && i + j < minIndexSum) {
    				minIndexSum = i + j;
    				result[0] = list1[i];
    			}
    		}
    	}
    	return result;
    }
}
