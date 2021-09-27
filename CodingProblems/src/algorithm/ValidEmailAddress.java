package algorithm;

import java.util.HashSet;
import java.util.Set;

public class ValidEmailAddress {

	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		String[] emails2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
		int count = numUniqueEmails(emails2);
		System.out.println(count);
	}
	
    public static int numUniqueEmails(String[] emails) {
    	Set<String> set = new HashSet<>();
    	
    	for (String email : emails) {
    		String[] emailArr = email.split("@");
    		String localName = emailArr[0];
    		
    		if (localName.indexOf('+') > 0) {
    			localName = localName.substring(0, localName.indexOf('+'));
    		}
    		localName = localName.replaceAll("\\.", "");
    		set.add(localName + "@" + emailArr[1]);
    	}
    	
    	return set.size();
    }
}
