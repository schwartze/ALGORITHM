package algorithm;

import java.util.Stack;

public class ClawCrane {
	
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		
		int[] moves = {1,5,3,5,1,2,1,4};
		
		int res = solution(board, moves);
		System.out.println(res);
	}

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
        	int pos = moves[i] - 1;
        	int target = 0;
        	
        	for (int j = 0; j < board.length; j++) {
        		target = board[j][pos];
        		
        		if (target != 0) {
        			board[j][pos] = 0;
        			break;
        		}
    		}
    		
			if (!stack.isEmpty() && stack.peek() == target) {
				answer += 2;
				stack.pop();
			} else {
				stack.add(target);
			}
        }
        return answer;
    }
}
