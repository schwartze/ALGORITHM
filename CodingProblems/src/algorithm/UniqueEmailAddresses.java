package algorithm;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

	public static void main(String[] args) {
		String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
		UniqueEmailAddresses emailAddress = new UniqueEmailAddresses();
		int num = emailAddress.numUniqueEmails(emails);
		System.out.println(num);
	}
	
	// An email address consists of two parts: local name and domain
	// #1. Periods(.) in local name  are ignored
	// #2. All words that are located after a plus sign (+) in local name are ignored
	// #3. The rule #1 and #2 apply to local name only 
	public int numUniqueEmails(String[] emails) {
    	Set<String> emailSet = new HashSet<>();
    	
    	for (String email : emails) {
    		StringBuilder sb = new StringBuilder();
    		String[] strArr = email.split("@");
    		String localName = strArr[0].
    							substring(0, strArr[0].indexOf("+")).
    							replaceAll(".", "");
    		
    		sb.append(localName);
    		sb.append("@");
    		sb.append(strArr[1]);
    		emailSet.add(sb.toString());
    	}
    	
    	return emailSet.size();
    }
}
