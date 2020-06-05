package algorithm;

public class SmallestLetter {

	public static void main(String[] args) {
		char[] letters = {'c', 'f', 'j'};
		char target = 'k';
		
		SmallestLetter letter = new SmallestLetter();
		char res = letter.nextGreatestLetter(letters, target);
		System.out.println(res);
	}
	
    public char nextGreatestLetter(char[] letters, char target) {
     
    	int min = Integer.MAX_VALUE;
    	
    	// if target is less than the greatest char in the array
    	for (char c : letters) {
    		
    		if (c <= target)
    			continue;
    		min = Math.min(min, (int)c);
    	}
    	
    	// if target is greater than the greatest char in the array
    	if (min == Integer.MAX_VALUE) {
    	
    		for (char c : letters) {
        		min = Math.min(min, (int)c);
        	}
        }
    	return (char)min;
    }
}
