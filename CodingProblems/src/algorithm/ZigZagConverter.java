package algorithm;

public class ZigZagConverter {
	
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 4;
		
		convert(s, numRows);
	}

    public static String convert(String s, int numRows) {
    	int length = 0, size = s.length();
    	
    	while (size > length) {
    		length += length > size ? length : numRows + (numRows - 2);
    		size -= length;
    	}

    	int[][] patternMatrix = new int[numRows][length];
    	
    	int row = 0, col = 0, idx = 1, route = 0;
    	boolean isStraightTurn = true;
    	patternMatrix[col][row] = s.charAt(0);
    	
    	for (int i = 1; i < s.length(); i++) {
    		
    		if (isStraightTurn) {
        		idx++;
    			col++;
        		patternMatrix[col][row] = s.charAt(i);
    		} else {
        		idx++;
    			col--;
    			patternMatrix[col][++row] = s.charAt(i);
    		}
    		
    		if (idx % numRows == 0) {
    			isStraightTurn = !isStraightTurn;
    			idx = 1;
    			row = 0;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0; i < patternMatrix.length; i++) {
    		
    		for (int j = 0; j < patternMatrix[i].length; j++) {
    			if (patternMatrix[i][j] > 0) {
    				sb.append((char)patternMatrix[i][j]);
    			}
    		}
    	}
    	
    	return sb.toString();
    }
}
