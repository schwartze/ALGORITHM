package algorithm;

public class LongPressedName {

	public static void main(String[] args) {
		String name = "laiden", typed = "laiden";
		LongPressedName lpName = new LongPressedName();
		boolean res = lpName.isLongPressedName(name, typed);
		System.out.println(res);
	}
	
	/*
	 * Your friend is typing his name into a keyboard.  
	 * Sometimes, when typing a character c, the key might get long pressed, 
	 * and the character will be typed 1 or more times.
	 * You examine the typed characters of the keyboard. 
	 * Return True if it is possible that it was your friends name, 
	 * with some characters (possibly none) being long pressed.
	 */
    public boolean isLongPressedName(String name, String typed) {
    	int j = 0;

    	for (int i = 0; i < name.length() - 1; i++) {
    		char letter = name.charAt(i);
    		boolean hasSameNextLetter = letter == name.charAt(i + 1);
    		
    		for (; j < typed.length() - 1;) {
    			
    			if (letter != typed.charAt(j))
    				return false;

    			if (hasSameNextLetter && letter == typed.charAt(j)) {
    				break;
    			} else {
        			if (letter == typed.charAt(j) && letter == typed.charAt(j + 1)) 
        				j++;
        			else 
        				break;
    			}
    		}
    		j++;
    	}
    	
    	return true;
    }
    
    public boolean isLongPressed(String name, String typed) {
        StringBuilder sb = new StringBuilder();
    	
    	for (int i = 0, nameIdx = 0; i < typed.length(); i++) {
    		
    		if  (nameIdx > 0 && name.charAt(nameIdx) != typed.charAt(i) && name.charAt(nameIdx - 1) == typed.charAt(i)) 
    			continue;
    		
    		if (name.charAt(nameIdx) == typed.charAt(i)) {
    			nameIdx++;
    			sb.append(typed.charAt(i));
    		} 

    		if (name.equals(sb.toString()))
    			return true;
    	}
    	return false;
    }
}
