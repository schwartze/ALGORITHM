package algorithm;

public class NextMaxNumber {

    public int solution(int n) {
        int increment = 1;
        while (true) {
        	if (Integer.bitCount(increment + n) == Integer.bitCount(n)) 
        		break;
        	increment++;
        }
        return n + increment;
    }
}
