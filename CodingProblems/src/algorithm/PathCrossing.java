package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PathCrossing {

	public static void main(String[] args) {
		String path = "NESWW";
		boolean res = isPathCrossing(path);
		System.out.println(res);
	}
	
    public static boolean isPathCrossing(String path) {
    	List<int[]> pathList = new ArrayList<>();
    	int[] currPos = new int[2];
    	pathList.add(new int[2]);
    	
    	for (char direction : path.toCharArray()) {

    		switch(direction) {
    			case 'N':
    				currPos[0]++;
    				break;
    			case 'S':
    				currPos[0]--;
    				break;
    			case 'E':
    				currPos[1]++;
    				break;
    			case 'W':
    				currPos[1]--;
    				break;
    		}
    		int[] pos = currPos.clone();

    		for (int[] pastPath : pathList) {
    			
    			if (pastPath[0] == pos[0] && pastPath[1] == pos[1]) 
    				return true;
    		}
    		pathList.add(pos);
    	}
    	return false;
    }
    
}
