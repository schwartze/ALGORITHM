package algorithm;

public class WorkInterval {

	public static void main(String[] args) {
	     int[] start  =  {1, 3, 0, 5, 8, 5};
	     int[] finish =  {2, 4, 6, 7, 9, 9};
	     
	     int res = getMaxNumberOfWork(start, finish);
	     System.out.println(res);
	}
	
	public static int getMaxNumberOfWork(int[] start, int[] finish) {
		int res = 1, i = 0;
		
		for (int j = 1; j < start.length; j++) {
			
			if (start[j] >= finish[i]) {
				i = j;
				res++;
			}
		}
		return res;
	}
}
