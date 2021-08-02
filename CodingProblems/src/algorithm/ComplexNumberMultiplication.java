package algorithm;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
        String firstPart1 = num1.substring(0, num1.indexOf("+"));
		String secondPart1 = num1.substring(num1.indexOf("+") + 1);
		int secondPart1Int = Integer.parseInt(secondPart1.substring(0, secondPart1.indexOf("i")));
		
		
		String firstPart2 = num2.substring(0, num2.indexOf("+"));
		String secondPart2 = num2.substring(num2.indexOf("+") + 1);
		int secondPart2Int = Integer.parseInt(secondPart2.substring(0, secondPart2.indexOf("i")));
		int res = (secondPart1Int * secondPart2Int * -1) + (Integer.parseInt(firstPart1) * Integer.parseInt(firstPart2)); 
		int imaginaryMultiplication = Integer.parseInt(firstPart1) * secondPart2Int + Integer.parseInt(firstPart2) * secondPart1Int;
		
		return res + "+" + imaginaryMultiplication + "i";
    }
}
