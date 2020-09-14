package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigramOccurrences {

	public static void main(String[] args) {
		String text = "ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv lnlqhmaohv lnlqhmaohv ypkk ypkk ypkk lnlqhmaohv lnlqhmaohv ypkk";
		String first = "lnlqhmaohv";
		String second = "ypkk";
		
		BigramOccurrences bOccurrences = new BigramOccurrences();
		String[] res = bOccurrences.findOccurrences(text, first, second);
		
		for (String str : res)
			System.out.println(str);
	}

	// When first and second words are given 
	// return the third word followed by first and second word respectively from the given string 
    public String[] findOccurrences(String text, String first, String second) {
    	String[] textArr = text.split(" ");
    	List<String> list = new ArrayList<>();
    	
    	for (int i = 0; i < textArr.length - 1 && i + 2 < textArr.length; i++) {
    		
    		if (textArr[i].equals(first) && textArr[i + 1].equals(second))
    			list.add(textArr[i + 2]);
    	}
    	return list.toArray(new String[list.size()]);
    }
}
