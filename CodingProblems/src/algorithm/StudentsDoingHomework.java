package algorithm;

public class StudentsDoingHomework {

	public static void main(String[] args) {
		int[] startTime = {9,8,7,6,5,4,3,2,1};
		int[] endTime = {10,10,10,10,10,10,10,10,10};
		int queryTime = 5;
		
		int res = busyStudent(startTime, endTime, queryTime);
		System.out.println(res);
	}
	
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    	int res = 0;
    	
    	for (int i = 0; i < endTime.length; i++) {
    		if (startTime[i] <= queryTime && endTime[i] >= queryTime)
    			res++; 
    	}
    	return res;
    }
}
