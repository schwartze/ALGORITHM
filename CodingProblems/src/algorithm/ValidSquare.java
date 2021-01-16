package algorithm;

public class ValidSquare {

	public static void main(String[] args) {
		// int w = 100000000, h = 999999999; // 99999998800000002
		int w = 8, h = 12; // 80

		ValidSquare vSquare = new ValidSquare();
		long res = vSquare.solution(w, h);
		System.out.println(res);
	}
	
	public long solution(int w, int h) {
    	long width = (long) w, height = (long) h;
    	long valid = 0;
        
        for (long i = height - 1; i >= 1; i--) {
        	if (i * width / height <= 0)
        		break;
    		valid += i * width / height;
        }
        
        return valid * 2;
    }
}
