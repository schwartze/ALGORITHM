package algorithm;

public class Roman {
	
	public static void main(String[] args) {
		String s = "IX";
		int res = romanToInt(s);
		System.out.println(res);
	}
    
	public static int romanToInt(String s) {
		int res = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			char next = i >= s.length() - 1 ? 'z' : s.charAt(i + 1); 
			
			if (curr == 'I') {
				
				if (next == 'V') {
					res += 4;
					i++;
				} else if (next == 'X') {
					res += 9;
					i++;
				} else {
					res++;
				}
			}
			
			if (curr == 'X') {
				
				if (next == 'L') {
					res += 40;
					i++;
				} else if (next == 'C') {
					res += 90;
					i++;
				} else {
					res += 10;
				}
			}
			
			if (curr == 'C') {
				
				if (next == 'D') {
					res += 400;
					i++;
				} else if (next == 'M') {
					res += 900;
					i++;
				} else {
					res += 100;
				}
			}
			
			switch (curr) {
				case 'V':
					curr += 5;
					break;
				case 'L':
					curr += 50;
					break;
				case 'D':
					curr += 500;
					break;
				case 'M':
					curr += 1000;
					break;
			}
		}
    	return res;
    }
}
