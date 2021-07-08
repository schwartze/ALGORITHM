package algorithm;

public class CountingBits {

    public int[] countBits(int num) {
    	int[] res = new int[num + 1];
    	
    	for (int i = 1; i <= num; i++) 
    		res[i] = getBits(i);
    	
    	return res;
    }
    
    private int getBits(int num) {
    	int count = 0;
    	
    	while (num > 0) {
    		count += num & 1;
    		num >>= 1;
    	}
    	
    	return count;
    }
}
