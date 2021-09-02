package algorithm;

import java.util.HashMap;
import java.util.Map;

public class RaceCompletion {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = new HashMap<>();
        
        for (String person : participant) {
        	participantMap.put(person, participantMap.getOrDefault(person, 0) + 1);
        }
    	
        for (String completedPerson : completion) {
        	
        	if (participantMap.containsKey(completedPerson)) {
        		
        		if (participantMap.get(completedPerson) > 1) {
        			participantMap.put(completedPerson, participantMap.get(completedPerson) - 1);
        		} else {
        			participantMap.remove(completedPerson);
        		}
        	}
        }
    	
        return participantMap.keySet().toArray(new String[0])[0];
    }
}
