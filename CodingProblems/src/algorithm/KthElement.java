package algorithm;

import java.util.Arrays;

public class KthElement {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[ commands.length ];
        
        for ( int i = 0; i < array.length; i++ ) {
        	int[] command = commands[i];
        	int[] rangedArr = new int[ command[1] - command[0] + 1 ];
			System.arraycopy( array, command[1], rangedArr, command[0], rangedArr.length );
			Arrays.sort( rangedArr );
			answer[i] = rangedArr[ command[2] ];
        }
        
        return answer;
    }
}
