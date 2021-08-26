package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestions {

	public static void main(String[] args) {
		String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
		String searchWord = "mouse";
		
		String[] products2 = {"havana"};
		String searchWord2 = "havana";
		
		String[] products3 = {"bags","baggage","banner","box","cloths"};
		String searchWord3 = "bags";
		
		
		List<List<String>> res = suggestedProducts(products3, searchWord3);
		
		for (List<String> list : res) {
			for (String str : list)
				System.out.print(str + ", ");
			System.out.println();
		}
	}
	
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    	List<List<String>> res = new ArrayList<List<String>>(searchWord.length());
    	Arrays.sort(products);
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < searchWord.length(); i++) {
    		sb.append(searchWord.substring(i, i + 1));
    		List<String> list = new ArrayList<>();
    		
    		for (int j = 0; j < products.length; j++) {
    			if (products[j].startsWith(sb.toString()))
    				list.add(products[j]);
    			
    			if (list.size() >= 3)
    				break;
    		}
    		res.add(list);
    	}
    	return res;
    }
}
