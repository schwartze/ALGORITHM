package algorithm;

public class BackspaceString {

	public static void main(String[] args) {
		String S = "e##e#o##oyof##q";
		String T = "e##e#fq##o##oyof##q";
		
		BackspaceString bString = new BackspaceString();
		boolean res = bString.backspaceCompare(S, T);
		System.out.println(res);
	}
	
    public boolean backspaceCompare(String S, String T) {
    	StringBuilder sbForS = new StringBuilder(S);
    	StringBuilder sbForT = new StringBuilder(T);
    	
    	while (sbForS.indexOf("#") != -1 || sbForT.indexOf("#") != -1) {
    		int idxS = sbForS.indexOf("#");
    		int idxT = sbForT.indexOf("#");
    		
    		if (idxS != -1) {
    			sbForS.deleteCharAt(idxS);
    			
    			if (idxS > 0 && sbForS.charAt(idxS - 1) > 0)
    				sbForS.deleteCharAt(idxS - 1);
    		}

    		if (idxT != -1) {
    			sbForT.deleteCharAt(idxT);
    			
    			if (idxT > 0 && sbForT.charAt(idxT - 1) > 0)
    				sbForT.deleteCharAt(idxT - 1);
    		}
    	}
    	
    	return sbForS.toString().contentEquals(sbForT.toString());
    }
}
