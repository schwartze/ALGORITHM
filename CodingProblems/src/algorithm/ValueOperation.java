package algorithm;

public class ValueOperation {

	public static void main(String[] args) {
		String[] operations = {"--X","X++","X++"};
		String[] operations2 = {"++X","++X","X++"}; 
		
		int value = finalValueAfterOperations(operations2);
		System.out.println(value);
	}
	
    public static int finalValueAfterOperations(String[] operations) {
    	int value = 0;
    	
    	for (String operation : operations) {
    		if (operation.charAt(0) == '+' || operation.charAt(operation.length() - 1) == '+')
    			value++;
    		else 
    			value--;
    	}
    	
    	return value;
    }
}
