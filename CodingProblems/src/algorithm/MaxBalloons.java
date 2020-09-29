package algorithm;

import java.util.HashMap;
import java.util.Map;

public class MaxBalloons {
	// nlaebolko / loonbalxballpoon / leetcode / balon
	public static void main(String[] args) {
		// String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
		String text = "nlaebolko";
		MaxBalloons mBalloons = new MaxBalloons();
		int res = mBalloons.maxNumberOfBalloons(text);
		System.out.println(res);
	}
	
    public int maxNumberOfBalloons(String text) {
    	char[] balloons = {'b', 'a', 'l', 'l', 'o', 'o', 'n'};
    	Map<Character, Integer> txtMap = new HashMap<>(text.length());
    	Map<Character, Integer> bMap = new HashMap<>(balloons.length);
    	int count = Integer.MAX_VALUE;
    	
    	for (char word : text.toCharArray()) 
    		txtMap.put(word, txtMap.getOrDefault(word, 0) + 1);
    		
    	for (char word : balloons) 
    		bMap.put(word, bMap.getOrDefault(word, 0) + 1);

    	for (char c : bMap.keySet()) {
    		
    		if (!txtMap.containsKey(c)) {
    			count = 0;
    			break;
    		}
    		if (txtMap.get(c) < bMap.get(c)) {
    			count = 0;
    			break;
    		}
    		
    		if (bMap.get(c) < 2)
    			count = Math.min(count, txtMap.get(c));
    		
    		if (bMap.get(c) > 1)
    			count = Math.min(count, txtMap.get(c) / bMap.get(c));
    	}
    	return count;
    }
}
