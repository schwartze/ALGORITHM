package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ChatRoomHistory {
	
	public static void main(String[] args) {
		String[] records = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		List<String> res = getEntranceHistory(records);
		
		for (String record : res)
			System.out.println(record);
	}

	public static List<String> getEntranceHistory(String[] records) {
		Map<String, String> map = new TreeMap<>();
		List<String> result = new ArrayList<>();
		
		for (String record : records) {
			String[] info = record.split(" ");
			if (info[0].contentEquals("Leave"))
				continue;
			
			String uid = info[1], nickname = info[2];
			
			if (!map.containsKey(uid)) {
				map.put(uid, nickname);
				continue;
			}
			
			map.replace(uid, nickname);
		}
		
		for (int i = 0; i < records.length; i++) {
			String[] info = records[i].split(" ");
			String finalNickname = map.get(info[1]);
			
			if (info[0].contentEquals("Enter")) {
				result.add(finalNickname + "님이 들어왔습니다.");
			} else if (info[0].contentEquals("Leave")) {
				result.add(finalNickname + "님이 나갔습니다.");
			}
		}
		return result;
	}
}
