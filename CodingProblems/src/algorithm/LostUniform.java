package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LostUniform {

	public static void main(String[] args) {
		int n = 5; 
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};

		int n2 = 5; 
		int[] lost2 = {2, 4};
		int[] reserve2 = {3};

		int n3 = 3; 
		int[] lost3 = {3};
		int[] reserve3 = {1};
		
		int n4 = 3; 
		int[] lost4 = {1, 2};
		int[] reserve4 = {2, 3};
		
		int res = maxStudentWithUniform(n4, lost4, reserve4);
		System.out.println(res);
	}
	
	// some students lost their uniform. But they can borrow uniform from those who have extras
	// students who lost their uniform can only borrow from adjacent students 
	// note that students with extra uniform can also lost their own, meaning they can't lend uniform to other students 
	// return the max number of students with uniform
	public static int maxStudentWithUniform(int n, int[] lost, int[] reserve) {
		Set<Integer> resSet = new HashSet<>(reserve.length);
		Set<Integer> lostSet = new HashSet<>(lost.length);
		List<Integer> dupList = new ArrayList<>();
		
		int studentCount = 0;

		for (int num : lost)
			lostSet.add(num);
		
		for (int num : reserve) {
			if (lostSet.contains(num)) {
				dupList.add(num);
				continue;
			}
			resSet.add(num);
		}

		for (int i = 0; i < dupList.size(); i++)
			if (lostSet.contains(dupList.get(i)))
				lostSet.remove(dupList.get(i));
				
		for (int i = 1; i <= n; i++) {
			
			if (!lostSet.contains(i)) {
				studentCount++;
				continue;
			}

			if (lostSet.contains(i) && resSet.contains(i - 1)) {
				studentCount++;
				resSet.remove(i - 1);
				continue;
			}

			if (lostSet.contains(i) && resSet.contains(i + 1)) {
				studentCount++;
				resSet.remove(i + 1);
				continue;
			}
		}

		return studentCount;
	}

	
	public static int studentWithUniform(int n, int[] lost, int[] reserve) {
		int[] students = new int[n];
		int res = n;
		
		for (int student : reserve) 
			students[student - 1]++;
		
		for (int student : lost)
			students[student - 1]--;
		
		for (int i = 0; i < students.length; i++) {
			if (students[i] == -1) {
				if (i - 1 >= 0 && students[i - 1] == 1) {
					students[i]++;
					students[i - 1]--;
				} else if (i + 1 < students.length && students[i + 1] == 1) {
					students[i]++;
					students[i + 1]--;
				} else {
					res--;
				}
			}
		}
		return res;
	}

}
