package algorithm;

public class SortColumns {

	public static void main(String[] args) {
		String[] A = {"abc", "bce", "cae"}; // 1
		String[] B = {"a","b"}; // 0
		String[] C = {"zyx","wvu","tsr"}; // 3
		String[] D = {"cba","daf","ghi"}; // 1
		String[] E = {"rrjk","furt","guzm"}; // 2
		String[] F = {"bybffvl","kbnknxg","lezkoaf","mhmuvsn","wpkxwyi","whgzxno"};
		
		int res = minDeletionSize(A);
		System.out.println(res);
	}
	
    public static int minDeletionSize(String[] A) {
    	int columnsToDelete = 0;
    	
    	for (int i = 0; i < A[0].length(); i++) {

    		for (int j = 0; j < A.length - 1; j++) {
    			if (A[j].charAt(i) > A[j + 1].charAt(i)) {
    				columnsToDelete++;
    				break;
    			}
    		}
    	}
    	return columnsToDelete;
    }
}
