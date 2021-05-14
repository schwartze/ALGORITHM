package algorithm;

import java.util.HashSet;
import java.util.Set;

public class LottoRanker {
	
	public static void main(String[] args) {
		int[] lottos = {0, 0, 0, 0, 0, 0};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		LottoRanker ranker = new LottoRanker();
		int[] res = ranker.solution(lottos, win_nums);
		
		System.out.println(res[0] + ", " + res[1]);
	}

    public int[] solution(int[] lottos, int[] win_nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : win_nums) 
        	set.add(num);
        
        int matchedCnt = 0, zeroCnt = 0;
        for (int lotto : lottos) {
        	if (set.contains(lotto)) 
        		matchedCnt++;
        	
        	if (lotto == 0)
        		zeroCnt++;
        }
        
        return new int[] {getRank(matchedCnt + zeroCnt), getRank(matchedCnt)};
    }
    
    private int getRank(int num) {
    	int rank = 0;
    	
    	switch (num) {
			case 6:
				rank = 1;
				break;
			case 5:
				rank = 2;
				break;
			case 4:
				rank = 3;
				break;
			case 3:
				rank = 4;
				break;
			case 2:
				rank = 5;
				break;
			default:
				rank = 6;
    	}
    	return rank;
    }
}
