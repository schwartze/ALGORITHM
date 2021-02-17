package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		String S = "ababcbacadefegdehijhklij";
		String S2 = "caedbdedda";
		String S3 = "eaaaabaaec";
		String S4 = "qiejxqfnqceocmy";
		String S5 = "mlullbhiuiujgvwvurcdvhzdk"
;		
		List<Integer> res = partitionLabels(S5);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	// Partition this string into as many parts as possible so that each letter appears in at most one part
    public static List<Integer> partitionLabels(String S) {
    	List<Integer> result = new ArrayList<>();
    	
    	int i = 0;
    	while (i < S.length()) {
    		char letter = S.charAt(i);
    		int lastIdx = S.lastIndexOf(letter);
    		
    		if (lastIdx == i) {
    			result.add(1);
    			i++;
    			continue;
    		}
    		
    		int lastIdxOfPartition = idxOfPartition(S, letter, i, lastIdx);
    		result.add(lastIdx + lastIdxOfPartition - i + 1);
    		i = lastIdx + lastIdxOfPartition + 1;
    	}
    	return result;
    }
    
    private static int idxOfPartition(String S, char letter, int startIdx, int lastIdx) {
    	int[] letters = new int[26];
    	int result = 0, toIdx = lastIdx;
    	
    	for (int i = startIdx + 1; i < toIdx; i++) {
    		if (letters[S.charAt(i) - 'a'] > 0 || S.charAt(i) == letter)
    			continue;
    		
    		letters[S.charAt(i) - 'a']++;
    		int lastAppearedAt = S.lastIndexOf(S.charAt(i));
    		
    		if (lastAppearedAt > lastIdx) {
    			result = Math.max(result, lastAppearedAt);
    			toIdx = result;
    		}
    	}
    	
    	return result > lastIdx ? result - lastIdx : result;
    }
}
