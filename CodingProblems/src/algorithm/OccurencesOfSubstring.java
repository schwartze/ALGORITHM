package algorithm;

public class OccurencesOfSubstring {
	
	public static void main(String[] args) {
		String s = "daabcbaabcbc";
		String part = "abc";
		
		String s2 = "axxxxyyyyb";
		String part2 = "xy";
		
		
		String res = removeOccurrences( s2, part2 );
		System.out.println( res );
	}
	
    public static String removeOccurrences( String s, String part ) {
    	StringBuilder sb = new StringBuilder( s );
    	
    	while ( sb.indexOf( part ) >= 0 ) {
    		int idx = sb.indexOf( part );
    		sb.delete( idx, idx + part.length());
    	}
    	return sb.toString();
    }
}
