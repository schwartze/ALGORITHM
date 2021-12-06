package algorithm;

public class NonexistingNumber {

	public int solution(int[] numbers) {
        int[] nums = new int[10];
        int ans = 0;
        
        for (int n : numbers) {
        	nums[n]++;
        }
        
        for (int n : nums) {
        	if (n == 0) {
        		ans += n;
        	}
        }
        return ans;
    }
}
