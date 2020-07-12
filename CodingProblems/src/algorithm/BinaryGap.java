package algorithm;

public class BinaryGap {
	
	public static void main(String[] args) {
		int N = 8;
		BinaryGap bGap = new BinaryGap();
		int res = bGap.binaryGap(N);
		System.out.println(res);
	}
	
	// return the longest distance between two consecutive 1's 
	// in the binary representation of N
    public int binaryGap(int N) {

    	String bitString = Integer.toBinaryString(N);
    	int maxGap = Integer.MIN_VALUE;
    	int onePos = 0;
    	
    	for (int i = 0; i < bitString.length(); i++) {
    		
    		if (bitString.charAt(i) == '1') {
    			maxGap = Math.max(maxGap, i - onePos);
    			onePos = i;
    		}
    	}
    	return maxGap;
    }

}
