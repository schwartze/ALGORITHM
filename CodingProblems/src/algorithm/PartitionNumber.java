package algorithm;

public class PartitionNumber {

	public static void main(String[] args) {
		String n = "82734";
		String n2 = "27346209830709182346";
		
		
		int res = minPartitions(n2);
		System.out.println(res);
	}
	/*
	 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros. For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
	 * Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.
	 */
	
    public static int minPartitions(String n) {
    	int max = 1;
    	
    	for (int i = 0; i < n.length(); i++) {
    		if (max < Integer.parseInt(n.charAt(i) + ""))
    			max = Integer.parseInt(n.charAt(i) + "");
    		
    		if (max >= 9)
    			break;
    	}
    	
    	return max;
    }
}
