package algorithm;

public class StudentsAndLunch {

	public static void main(String[] args) {
		int[] students = {1,1,0,0};
		int[] sandwiches = {0,1,0,1};
	
		int res = countStudents(students, sandwiches);
		System.out.println(res);
	}
	
    public static int countStudents(int[] students, int[] sandwiches) {
    	int wPointer = 0, sPointer = 0, hungryStudent = students.length;
    	
    	while (hungryStudent != 0) {
    		
    		if (students[sPointer] == sandwiches[wPointer]) {
    			if (students[sPointer] == -1)
    				continue;
    			
    			students[sPointer] = -1;
    			sandwiches[wPointer] = -1;
    			wPointer++;
    			hungryStudent--;
    		}
    		sPointer++;
    		if (sPointer == students.length) {
    			sPointer = 0;
    		}
    	}
    	
    	return hungryStudent;
    }
}
