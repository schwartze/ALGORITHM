package algorithm;

import java.util.ArrayList;
import java.util.List;

public class NumberPrefix {

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book2 = {"123","456","789"};
		String[] phone_book3 = {"12","123","1235","567","88"};
		
		boolean res = solution(phone_book3);
		System.out.println(res);
	}
	
    public static boolean solution(String[] phone_book) {
       boolean answer = true;
       List<String> list = new ArrayList<>();
       
       for (String phone : phone_book) {
    	   
    	   for (int i = 0; i < list.size(); i++) {
    		   String current = list.get(i);
    		   
    		   if (current.indexOf(phone) >= 0 || phone.indexOf(current) >= 0) {
    			   return false;
    		   }
    	   }
    	   list.add(phone);
       }
        
        return answer;
    }
}
