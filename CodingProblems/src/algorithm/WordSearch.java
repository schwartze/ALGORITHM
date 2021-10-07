package algorithm;

public class WordSearch {

	public static void main(String[] args) {
		char[][] board = {
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
		};
		
		String word = "SEE";
		
		boolean res = exist(board, word);
		System.out.println(res);
	}
	
    public static boolean exist(char[][] board, String word) {
    	int idx = 0;
    	
    	for (int i = 0; i < board.length; i++) {
    		
    		for (int j = 0; j < board[i].length; j++) {
    			char target = word.charAt(idx);
    			
    			if (board[i][j] != target)
    				continue;

    			int[] point = getTargetPoint(board, i, j, word, idx + 1);
    			
    			if (point[0] != -1 && point[1] != -1)
    				return true;
    		}
    	}
    	return false;
    }
    
   
    private static int[] getTargetPoint(char[][] board, int i, int j, String word, int idx) {
    	if (idx >= word.length()) 
    		return new int[] {i, j};
    	
    	char target = word.charAt(idx);
    	
    	if (j < board[i].length - 1 && board[i][j + 1] == target) 
    		return getTargetPoint(board, i, j + 1, word, idx + 1);
    	
    	if (j > 0 && board[i][j - 1] == target) 
    		return getTargetPoint(board, i, j - 1, word, idx + 1);

    	if (i < board.length - 1 && board[i + 1][j] == target) 
    		return getTargetPoint(board, i + 1, j, word, idx + 1);
    	
    	if (i > 0 && board[i - 1][j] == target) 
			return getTargetPoint(board, i - 1, j, word, idx + 1);
    	
    	return new int[] {-1, -1};
    }
    
}
