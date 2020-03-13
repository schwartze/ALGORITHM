package algorithm;

public class NumberComplement {

	// return numberComplement
	// meaning if given number is 5 (101)
	// the output is 2 (010)
	public int getNumberComplement(int num) {
		
		if (num == 1)
			return 0;
		
		int result = 1;
				
		while (true) {
			
			if ((num & result) == 0)
				break;
			
			result++;
		}
		
		return 0;
	}
}
