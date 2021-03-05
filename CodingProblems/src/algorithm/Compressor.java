package algorithm;

public class Compressor {

	public static void main(String[] args) {
		String s = "aabbaccc"; // 7
		String s2 = "ababcdcdababcdcd"; // 9
		String s3 = "abcabcdede"; // 8
		String s4 = "abcabcabcabcdededededede"; // 14
		String s5 = "xababcdcdababcdcd"; // 17
		String s6 = "abcdabcd";
		String s7 = "xxxxxxxxxxyyy"; // 5
		String s8 = "bbaabaaaab"; // 8
		String s9 = "zzzbbabbabba"; //7 틀림
		String s10 = "aaaaaaaaaab"; // 4
		String s11 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String s12 = "zxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String s13 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxz";
		
		
		int res = compress(s13);
		System.out.println(res);
	}
	
	public static int compress(String s) {
		int result = s.length();
		int prevIdx = 0;
		
		while (s.indexOf(s.charAt(0), prevIdx + 1) > 0) {
			StringBuilder sb = new StringBuilder();
			int nextIdx = s.indexOf(s.charAt(0), prevIdx + 1);
			String prev = s.substring(0, nextIdx);
			int cnt = 1;
			
			for (int i = nextIdx; i < s.length(); i+=nextIdx) {
				String temp = "";
				if (i + nextIdx < s.length()) 
					temp = s.substring(i, i + nextIdx);
				else 
					temp = s.substring(i);
				
				if (temp.contentEquals(prev)) {
					cnt++;					
				} else {
					if (cnt > 1)
						sb.append(cnt);
					sb.append(prev);
					cnt = 1;
				}
				prev = temp;
			}
			if (cnt > 1)
				sb.append(cnt);
			sb.append(prev);
			prevIdx = nextIdx;
			result = Math.min(result, sb.length());
		}
		return result;
	}
}
