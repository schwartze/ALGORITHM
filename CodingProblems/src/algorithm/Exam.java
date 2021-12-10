package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {
	
    public List<Integer> solution(int[] answers) {
        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Map<Integer, Integer> scoreMap = new HashMap<>();
        
        for (int i = 0; i < answers.length; i++) {
        	if (person1[i % person1.length] == answers[i]) {
        		scoreMap.put(1, scoreMap.getOrDefault(1, 1) + 1);
        	}
        	
        	if (person2[i % person2.length] == answers[i]) {
        		scoreMap.put(2, scoreMap.getOrDefault(2, 1) + 1);
        	}
        	
        	if (person3[i % person3.length] == answers[i]) {
        		scoreMap.put(3, scoreMap.getOrDefault(3, 1) + 1);
        	}
        }
        
        int highestScore = 0;
        for (int val : scoreMap.values()) {
        	highestScore = Math.max(highestScore, val);
        }
        
        List<Integer> result = new ArrayList<>();
        for (int key : scoreMap.keySet()) {
        	if (scoreMap.get(key) == highestScore) {
        		result.add(key);
        	}
        }
        
        return result;
    }
}
