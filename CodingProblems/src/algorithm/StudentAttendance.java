package algorithm;

import java.util.HashMap;

public class StudentAttendance {

	public static void main(String[] args) {
		StudentAttendance attendance = new StudentAttendance();
		
		boolean result = attendance.rewardable("PPALLL");
		System.out.println(result);
	}
	
	// 1. 'A' : Absent
	// 2. 'L' : Late
	// 3. 'P' : Present 
	// a student can be rewarded if his attendance does not contain
	// more than one Absent or more than two continuous Late record
	public boolean rewardable(String s) {
		
		int absentCount = 0;
		int lateCount = 0;
		boolean continuousFlag = true;
		
		for (char c : s.toCharArray()) {
			
			if (c == 'A')
				absentCount++;
			
			if (absentCount > 1)
				return false;

			if (c == 'L')
				continuousFlag = true;
			
			if (c == 'L' && continuousFlag == true)
				lateCount++;
		}

		return lateCount > 2 ? false : true;
	}
	
}
