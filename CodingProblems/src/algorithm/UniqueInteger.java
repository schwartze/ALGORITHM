package algorithm;

public class UniqueInteger {

	public static void main(String[] args) {
		int n = 5;
		
		int[] res = sumZero(n);
		
		for (int num : res) {
			System.out.print(num + ", ");
		}
	}
	
    public static int[] sumZero(int n) {
    	int[] res = new int[n];
    	
    	int index = 0, num = 1;
    	
    	while (index + 1 < n) {
    		res[index] = num;
    		res[++index] = num * -1;
    		num++;
    		index++;
    	}
    	
    	return res;
    }
}
