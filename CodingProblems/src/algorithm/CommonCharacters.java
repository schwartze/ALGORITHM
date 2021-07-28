package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonCharacters {

	public static void main(String[] args) {
		String[] A = {"bella", "label", "roller"};
		String[] B = {"acabcddd","bcbdbcbd","baddbadb","cbdddcac","aacbcccd","ccccddda","cababaab","addcaccd"};
		String[] C = {"cool", "cook", "lock"};
		List<String> res = commonChars2(C);

		for (String s : res)
			System.out.print(s + ", ");
	}
	
    public List<String> commonChars(String[] A) {
    	List<String> res = new ArrayList<>();
    	Map<Character, int[]> map = new HashMap<>();
    	
    	for (int i = 0; i < A.length; i++) {
    		for (char c : A[i].toCharArray()) {
    			int[] arr;
    			if (map.containsKey(c)) {
    				arr = map.get(c);
    				arr[i]++;
    				continue;
    			}
    			arr = new int[A.length];
    			arr[i]++;
    			map.put(c, arr);
    		}
    	}
    	for (char key : map.keySet()) {
    		int[] arr = map.get(key);
    		
    		for (int i = 0; i < arr.length - 1; i++)
    			if (arr[i] != arr[i + 1])
    				continue;
    		
    		for (int i = 0; i < arr[0]; i++) 
    			res.add(key + "");
    		
    	}
    	return res;
    }
    
    public static List<String> commonChars2(String[] A) {
    	List<String> res = new ArrayList<>();
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for (char c : A[0].toCharArray()) 
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	
    	for (int i = 1; i < A.length; i++) {
    		Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
    		List<Character> keyList = new ArrayList<>();
    		
    		for (int j = 0; j < A[i].length(); j++) 
    			tempMap.put(A[i].charAt(j), tempMap.getOrDefault(A[i].charAt(j), 0) + 1);
    		
    		for (char key : map.keySet()) {
    			if (!tempMap.containsKey(key)) {
    				keyList.add(key);
    				continue;
    			}
    			if (tempMap.get(key) < map.get(key)) {
    				map.put(key, tempMap.get(key));
    			}
    		}
    		
    		for (int j = 0; j < keyList.size(); j++)
    			map.remove(keyList.get(j));
    	}
    	
    	for (char key : map.keySet()) {
    		
    		for (int i = 0; i < map.get(key); i++) {
    			res.add(key + "");
    		}
    	}
    	return res;
    }
    
    public static void mergeSort(int[] arr, int l, int r) {
    	
    	if (l < r) {
    		
    		int m = (l + r) / 2;
    		mergeSort(arr, l, m);
    		mergeSort(arr, m, r);
    		
    		merge(arr, l, m, r);
    	}
    }
    
    private static void merge(int[] arr, int q, int p, int r) {
    	
    	int N = p - q + 1;
    	int M = r - p;
    	
    	int[] n = new int[N];
    	int[] m = new int[M];
    	
    	for (int i = 0; i < N; i++) {
    		n[i] = arr[q + i];
    	}
    	
    	for (int i = 0; i < M; i++) {
    		m[i] = arr[p + 1 + i];
    	}
    	
    	int i = 0, j = 0, k = r;
    	while (i < N && j < M) {
    		
    		if (n[i] <= m[j]) {
    			arr[k] = n[i];
    			i++;
    		} else {
    			arr[k] = m[j];
    			j++;
    		}
    		k++;
    	}
    	
    	while (i < N) {
    		arr[k] = n[i];
    		k++;
    		i++;
    	}
    	
    	while (j < M) {
    		arr[k] = m[j];
    		k++;
    		j++;
;    	}
    }
}
