package algorithm;

public class MatchesInTournament {
    
	public static void main(String[] args) {
		int n = 14;
		int res = numberOfMatches(n);
		System.out.println(res);
	}
	/*
	 * If the current number of teams is even, each team gets paired with another team. 
	 * A total of n / 2 matches are played, and n / 2 teams advance to the next round.
	 * If the current number of teams is odd, one team randomly advances in the tournament, 
	 * and the rest gets paired. A total of (n - 1) / 2 matches are played, 
	 * and (n - 1) / 2 + 1 teams advance to the next round.
	 */
	public static int numberOfMatches(int n) {
		int matches = 0;
		
		while (n > 1) {
			matches += n / 2;

			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = (n / 2) + 1;
			}
		}
    	return matches;
    }
}
