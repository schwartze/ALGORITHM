package algorithm;

import java.util.Arrays;

public class HIndex {
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5}; // 3
		int[] citations2 = {12,11,10,9,8,1}; // 5
		int[] citations3 = {6,6,6,6,6,1}; // 5
		int[] citations4 = {20,21,22,23}; // 
		int[] citations5 = {4,4,4}; // 3
		int[] citations6 = {4, 4, 4, 5, 0, 1, 2, 3}; // 4
		int[] citations7 = {10, 11, 12, 13}; // 4
		int[] citations8 = {3, 0, 6, 1, 5}; // 3
		int[] citations9 = {0, 0, 1, 1}; // 1
		int[] citations10 = {0, 1};
		int[] citations11 = {10, 9, 4, 1, 1};
		int hIndex = solution(citations8);
		System.out.println(hIndex);
	}

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for (int i = citations.length - 1; i >= 0; i--) {
        	if (citations[i] <= answer) 
        		break;
        	answer++;
        }
        
        return answer;
    }
}
