package algorithm;

public class DecodeArray {

	public static void main(String[] args) {
//		int[] encoded = {1, 2, 3}; 
//		int first = 1;

		int[] encoded = {6, 2, 7, 3}; 
		int first = 4;

		
		int[] res = decode(encoded, first);
		for (int n : res)
			System.out.print(n + ", ");
			
	}
	/*
	 * It was encoded into another integer array encoded of length n - 1, 
	 * such that encoded[i] = arr[i] XOR arr[i + 1]. 
	 * For example, if arr = [1,0,2,1], then encoded = [1,2,3].
	 */
    public static int[] decode(int[] encoded, int first) {
    	int[] decoded = new int[encoded.length + 1];
    	decoded[0] = first;
    	
    	for (int i = 0; i < encoded.length; i++) 
    		decoded[i + 1] = encoded[i] ^ decoded[i]; 
    	
    	return decoded;
    }
}
