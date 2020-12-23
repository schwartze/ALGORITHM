package algorithm;

public class LogFolder {

	public static void main(String[] args) {
		String[] logs = {"./","../","./"};
		int res = minOperations(logs);
		System.out.println(res);
	}
	/*
	 * The operations are described below:
	 *	"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
	 *	"./" : Remain in the same folder.
	 *	"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
	 */
    public static int minOperations(String[] logs) {
    	int res = 0;
    	
    	for (int i = 0; i < logs.length; i++) {
    		if (logs[i].matches("\\.\\.\\/")) {
    			if (res > 0)
    				res--;
    			continue;
    		}
    		
    		if (logs[i].matches("\\.\\/")) {
    			continue;
    		}
    		res++;
    	}
    	return res;
    }
}
