package algorithm;

public class ProductAndSum {

	public static void main(String[] args) {
		int n = 4421;
		ProductAndSum pns = new ProductAndSum();
		int res = pns.subtractProductAndSum(n);
		System.out.println(res);
	}
	
    public int subtractProductAndSum(int n) {
    	int product = 1, sum = 0;
    	
    	while (true) {
    		int modulo = n % 10;
    		n /= 10;
    		
			product *= modulo;
			sum += modulo;
    		if (n < 10) {
    			product *= modulo;
    			sum += modulo;
        		break;
    		}
    	}
    	
    	return product - sum;
    }
}
