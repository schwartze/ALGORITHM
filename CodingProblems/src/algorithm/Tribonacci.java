package algorithm;

public class Tribonacci {

	public static void main(String[] args) {
		Tribonacci trib = new Tribonacci();
		int n = 2;
		int res = trib.tribonacci(n);
		System.out.println(res);
	}
	
    public int tribonacci(int n) {
    	if (n < 3)
    		return n > 0 ? 1 : 0;

    	int seq = 3, sum = 0;
    	int first = 0, second = 1, third = 1;
    	
    	while (seq <= n) {
    		sum = first + second + third;
    		first = second;
    		second = third;
    		third = sum;
    		seq++;
    	}
    	
    	return sum;
    }
}
