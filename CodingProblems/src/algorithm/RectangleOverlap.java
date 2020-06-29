package algorithm;

public class RectangleOverlap {

	public static void main(String[] args) {
		int[] rec1 = {0, 0, 2, 2};
		int[] rec2 = {1, 1, 3, 3};
		
		int[] rec3 = {0, 0, 1, 1};
		int[] rec4 = {1, 0, 2, 1};
		
		RectangleOverlap rectangle = new RectangleOverlap();
		boolean res = rectangle.isRectangleOverlap(rec3, rec4);
		
		System.out.println(res);
	}
	
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    	boolean res = false;

    	// rec2[0] < rec1[0] < rec2[2] || rec2[0] < rec1[2] < rec2[2]
    	// rec2[1] < rec1[1] < rec2[3] || rec2[1] < rec1[3] < rec2[3]
    	
    	if ((rec1[0] > rec2[0] && rec1[0] < rec2[2]) || (rec1[2] > rec2[0] && rec1[2] < rec2[2]))
    		if ((rec1[1] > rec2[1] && rec1[1] < rec2[3]) || (rec1[3] > rec2[1] && rec1[3] < rec2[3])) 
    			res = true;
    	
    	return res;
    }
}
