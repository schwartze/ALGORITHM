package algorithm;

import java.util.HashMap;
import java.util.Map;

public class SongPlayer {
	
	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicInfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		
		String songFound = findSong(m, musicInfos);
		System.out.println(songFound);
	}

    public static String findSong(String m, String[] musicInfos) {
        String answer = "(None)";
        int maxDuration = 0;
        
        Map<String, String> songMap = new HashMap<>();
        
        for (int i = 0; i < musicInfos.length; i++) {
        	String[] info = musicInfos[i].split(",");
        	
        	int duration = getSongDuration(info[0], info[1]);
        	String playedMelody = getPlayedMelody(duration, info[3]);
        	songMap.put(info[2], playedMelody);
        }
        
        for (String songTitle : songMap.keySet()) {
        	
        	String allMelody = songMap.get(songTitle);
        	
        	int duration = Integer.parseInt(allMelody.substring(allMelody.indexOf("-") + 1, allMelody.length()));
        	if (allMelody.indexOf(m) >= 0 && duration > maxDuration) {
        		answer = songTitle;
        		maxDuration = duration;
        	}
        }
        return answer;
    }
    
    private static int getSongDuration(String startTime, String endTime) {
    	String startTimeStr = startTime.substring(0, startTime.indexOf(":"));
    	String startHourStr = startTime.substring(startTime.indexOf(":") + 1);

    	String endTimeStr = endTime.substring(0, endTime.indexOf(":"));
    	String endHourStr = endTime.substring(endTime.indexOf(":") + 1);
    	
    	int duration = ((Integer.parseInt(endTimeStr) - Integer.parseInt(startTimeStr)) * 60) + 
    			(Integer.parseInt(endHourStr) - Integer.parseInt(startHourStr));
    	
    	return duration;
    }
    
    private static int getMelodyLength(String melody) {
    	int melogyLength = 0;
    	
    	for (int j = 0; j < melody.length(); j++) {
    		if (j < melody.length() - 1 && melody.charAt(j + 1) == '#') {
    			melogyLength++;
    			j++;
    			continue;
    		}
    		melogyLength++;
    	}
    	
    	return melogyLength;
    }
    
    private static String getPlayedMelody(int duration, String givenMelody) {
    	int melodyLength = getMelodyLength(givenMelody);
    	StringBuilder sb = new StringBuilder(givenMelody);
    	
    	if (duration < melodyLength) {
    		sb.append(givenMelody.substring(0, duration));
    		sb.append("-");
        	sb.append(duration);
    		return sb.toString();
    	}
    	
    	int i = melodyLength;
    	while (i < duration) {
    		sb.append(givenMelody);
    		i += melodyLength;
    	}
    	
    	sb.append(givenMelody.substring(0, duration - i));
    	sb.append("-");
    	sb.append(duration);
    	return sb.toString();
    }
}
