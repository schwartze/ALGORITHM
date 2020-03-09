package algorithm;

public class HammingDistance {

	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.getHammingDistance(1, 4));
	}
	
	// Hamming distance between two integers is the number of 
	// positions at which the corresponding bits are different
    public int getHammingDistance(int x, int y) {
       
    	return Integer.bitCount(x ^ y);
    }
}
