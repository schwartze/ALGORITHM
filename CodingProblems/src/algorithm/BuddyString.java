package algorithm;

public class BuddyString {

    public boolean buddyStrings(String s, String goal) {
        for (int i = 0; i < s.length(); i++) {
			if (goal.indexOf(s.charAt(i)) < 0)
				continue;
			
			for (int j = i + 1; j < s.length(); j++) {
				StringBuilder sb = new StringBuilder(s);
				sb.replace(i, i + 1, s.charAt(j) + "");
				sb.replace(j, j + 1, s.charAt(i) + "");
				
				if (goal.equals(sb.toString()))
					return true;
			}
		}
		
    	return false;
    }
}
