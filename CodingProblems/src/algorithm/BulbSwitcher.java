package algorithm;

public class BulbSwitcher {

	public static void main(String[] args) {
		String target = "10111";
		String target2 = "101";
		String target3 = "00000";
		String target4 = "001011101";
		
		int res = minFlips(target4);
		System.out.println(res);
	}
	
    public static int minFlips(String target) {
    	char currentBulb = '0';
    	int flipCount = 0;
    	
    	for (int i = 0; i < target.length(); i++) {
    		if (target.charAt(i) != currentBulb) {
    			flipCount++;
    			currentBulb = currentBulb == '0' ? '1' : '0'; 
    		}
    	}
    	
    	return flipCount;
    }
}
