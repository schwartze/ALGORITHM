package algorithm;

public class LetterTile {

	public static void main(String[] args) {
		String tiles = "AAB";
		
		int res = numTilePossibilities(tiles);
		System.out.println(res);
	}
	
    public static int numTilePossibilities(String tiles) {
    	int[] letters = new int[26];
    	
    	for (char c : tiles.toCharArray()) {
    		letters[c - 65]++;
    	}
    	return dfs(letters);
    }
    
    private static int dfs(int[] arr) {
    	int sum = 0;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] == 0)
    			continue;
    		
    		sum++;
    		arr[i]--;
    		sum += dfs(arr);
    		arr[i]++;
    	}
    	
    	return sum;
    }
    
}
