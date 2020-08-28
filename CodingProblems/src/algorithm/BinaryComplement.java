package algorithm;

public class BinaryComplement {

	public static void main(String[] args) {
		int N = 5;
		BinaryComplement bCom = new BinaryComplement();
		int res = bCom.bitwiseComplement(N);
		System.out.println(res);
	}
	
    public int bitwiseComplement(int N) {
    	int notN = ~N;
    	String nStr = Integer.toBinaryString(N);
    	String notNStr = Integer.toBinaryString(notN);
    	
    	return Integer.parseInt(notNStr.substring(notNStr.length() - nStr.length(), notNStr.length()), 2);
    }
}
