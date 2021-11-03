package algorithm;

public class HammingDistance {

	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(3, 1));
	}
	
	// Hamming distance between two integers is the number of 
	// positions at which the corresponding bits are different
    public int hammingDistance(int x, int y) {
    	return Integer.bitCount(x ^ y);
    }
}
