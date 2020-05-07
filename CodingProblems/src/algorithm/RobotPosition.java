package algorithm;

public class RobotPosition {

	public static void main(String[] args) {
		RobotPosition pos = new RobotPosition();
		boolean result = pos.judgeCircle("LL");
		System.out.println(result);
	}
	// With a given moves of a robot in String, find if it ends up at position 0,0
	// moves : R(right), L(left), U(up), D(down)
    public boolean judgeCircle(String moves) {
    	int xPos = 0;
    	int yPos = 0;
    	
    	for (char c : moves.toCharArray()) {
    		
    		if (c == 'R')
    			xPos++;
    		else if (c == 'L')
    			xPos--;
    		else if (c == 'U')
    			yPos++;
    		else if (c == 'D')
    			yPos--;
    	}
    	
    	return xPos == 0 && yPos == 0;
    }
}
