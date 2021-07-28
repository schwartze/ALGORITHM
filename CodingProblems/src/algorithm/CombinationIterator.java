package algorithm;

import java.util.Queue;

public class CombinationIterator {

	Queue<String> queue;
	
    public CombinationIterator(String characters, int combinationLength) {
        generateSub(characters, combinationLength, 0, new StringBuilder());
    }
    
    private void generateSub(String s ,int len,int start,StringBuilder result) {
        if (len == 0){
        	queue.add(result.toString());
            return;
        }
        for (int i = start; i <= s.length() - len; i++){
            result.append(s.charAt(i));
            generateSub(s, len - 1, i + 1, result);
            result.deleteCharAt(result.length() - 1);
        }
    }
    
    public String next() {
    	return queue.poll();
    }
    
    public boolean hasNext() {
    	return !queue.isEmpty();
    }
}
