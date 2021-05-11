package algorithm;

public class ReinitializePermutation {

    public int reinitializePermutation(int n) {
        int max = 0;
		
		for (int i = 0; i < n; i++) {
			int operationCount = operateNumber(1, i, i, n);
			
			if (operationCount > max)
				max = operationCount;
		}
		return max;
    }
    
    private int operateNumber(int count, int initial, int i, int n) {
		int current = 0;
		
		if (i % 2 == 0) 
			current = i / 2;
		else 
			current = (n / 2) + (i - 1) / 2;
		
		return initial == current ? count : operateNumber(count + 1, initial, current, n);
	}
}
