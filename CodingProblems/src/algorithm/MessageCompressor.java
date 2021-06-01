package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageCompressor {
	
	public static void main(String[] args) {
		String message = "KAKAO";
		String message2 = "TOBEORNOTTOBEORTOBEORNOT";
		String message3 = "ABABABABABABABAB";
		
		MessageCompressor compressor = new MessageCompressor();
		int[] res = compressor.compress(message3);
		
		for (int n : res)
			System.out.print(n + ", ");
		
	}

	public int[] compress(String message) {
		Map<String, Integer> wordMap = new HashMap<>();
		fillMap(wordMap);
		List<Integer> indexList = new ArrayList<>();
		int arrIdx = 27;
		
		for (int i = 0; i < message.length(); i++) {
			boolean lastFlag = false;
			char current = message.charAt(i);
			StringBuilder sb = new StringBuilder(current + "");
			int j = i;
			
			while (true) {
				if (!wordMap.containsKey(sb.toString())) {
					indexList.add(wordMap.get(sb.substring(0, sb.length() - 1)));
					wordMap.put(sb.toString(), arrIdx++);
					break;
				}
				
				if (j == message.length() - 1) {
					indexList.add(wordMap.get(sb.toString()));
					lastFlag = true;
					break;
				}
				sb.append(message.charAt(++j));
			}
			if (lastFlag)
				break;
			i = --j;
		}
		
		int[] res = new int[indexList.size()];
		
		for (int i = 0; i < indexList.size(); i++)
			res[i] = indexList.get(i);
		
		return res;
	}
	
	private void fillMap(Map<String, Integer> map) {
		for (int i = 1; i < 27; i++) {
			map.put((char)(64 + i) + "", i);
		}
	}
			
}


