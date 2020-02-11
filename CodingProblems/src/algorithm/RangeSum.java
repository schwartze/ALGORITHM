package algorithm;

public class RangeSum {
	private int[] num;
	
	public RangeSum(int[] num) {
		this.num = new int[num.length + 1];
		
		// compute cummulative sum and store its value in this.Num array.
		for (int i = 0; i < num.length; i++) {
			this.num[i + 1] = this.num[i] + num[i];
		}
	}
	
	public int getSum(int i, int j) {
		
		return num[j + 1] - num[i];
	}
	
	public static void main(String[] args) {
		int[] num = {-2, 0, 3, -5, 2, -1};
		
		RangeSum rSum = new RangeSum(num);
		int result = rSum.getSum(2, 5);
		
		System.out.println(result);
	}
}
