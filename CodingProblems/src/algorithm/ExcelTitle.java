package algorithm;

public class ExcelTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
    	boolean isDivisor = false;
    	
    	while (columnNumber > 26) {
    		int mod = columnNumber % 26;
    		columnNumber /= 26;
    		
    		if (mod == 0) {
    			sb.append((char)(26 + 64));
    			isDivisor = true;
    		}
    		else 
    			sb.append((char)(mod + 64));
    	}
    	if (isDivisor) 
    		sb.append((char)(columnNumber + 63));
    	else 
    		sb.append((char)(columnNumber + 64));

    	return sb.reverse().toString();
    }
}
