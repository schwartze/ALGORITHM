package algorithm;

import java.util.HashSet;
import java.util.Set;

public class ConnectingWords {

	public static void main(String[] args) {
		String[] words = {"hello",	"observe",	"effect",	"take",	"either",	"recognize",	"encourage",	"ensure",	"establish",	"hang",	"gather",	"refer",	"reference",	"estimate",	"executive"};
		int n = 3;
		
		String[] words2 = {"hello", "one", "even", "never", "now", "world", "draw"};
		int n2 = 2;
		
		String[] words3 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int n3 = 3;
		
		int[] res = solution(n3, words3);
		System.out.println(res[0] + ", " + res[1]);
	}
	
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int round = 1;
        
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
        	
        	if (i % n == 0)
        		round++;
        	
        	if (wordSet.contains(words[i]) || 
        			words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
        		answer[0] = i % n + 1;
        		answer[1] = round;
        		break;
        	}
        	wordSet.add(words[i]);
        }
        
        return answer;
    }
}
