package algorithm;

public class MaxNumber {

	public static void main(String[] args) {
		int num = 9669;
		int res = maximum69Number(num);
		System.out.println(res);
	}
	
    public static int maximum69Number (int num) {
    	
    	return Integer.parseInt(Integer.toString(num).
					replaceFirst("[6]", "9"));
    }
}
