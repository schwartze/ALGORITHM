package algorithm;

public class BaseballGame {
/*
 * 
Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a r
 */
	public int getScore(String[] ops) {
		int res = 0;
		
		for (int i = 0; i < ops.length; i++) {
			int d = 0;
			int plus = 0;
			
			if (ops[i].equals("C") && ops[i].equals("D") && ops[i].equals("+"))
				res += Integer.parseInt(ops[i]);
			
			if (ops[i].equals("D")) {
				int j = 0;
				
				if (ops[i].equals("+"))
					res += plus;
				else if (ops[i].equals("X")) {
					while (ops[j].equals("X"))
						j++;
					d += Integer.parseInt(ops[j]);
				}
				res += d;
			}
			
			if (ops[i].equals("C")) {
				ops[i] = "X";
				int j = i;
				
				while (ops[j].equals("+") || ops[j].equals("D"))
					j++;
				ops[j] = "X";
			}
			
			if (ops[i].equals("+")) {
				int j = i;
				int count = 0;
				
				while (count < 3) {
					
					if (ops[j].equals("X"))
						j++;
					
					if (ops[j].equals("D")) {
						count++;
						res += d;
					}
					
					if (ops[j].equals("+")) {
						count++;
						res += d;
					}
					
					res += Integer.parseInt(ops[j]);
					count++;
				}
			}
		}
		return res;
	}
}
