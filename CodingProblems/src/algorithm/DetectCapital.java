package algorithm;

public class DetectCapital {

	public static void main(String[] args) {
		DetectCapital cap = new DetectCapital();
		boolean result = cap.canDetectCapital("Google");
		System.out.println(result);
	}
	
	public boolean canDetectCapital(String str) {
		// a given string is capital if it falls in one of below categories
		// 1. all uppercase. i.e.) USA
		// 2. all lowercase. i.e.) chocolate
		// 3. all lowercase except the first letter. i.e.) Google
		
		int capCount = 0;
		
		for (char c : str.toCharArray()) {
			
			if ('Z' - c >= 0)
				capCount++;
		}
		
		return capCount == 0 || capCount == str.length() || (capCount == 1 && 'Z' - str.charAt(0) >= 0);
	}
}
