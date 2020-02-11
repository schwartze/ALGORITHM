package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public static void main(String[] args) {
		String a = "3:14";
		
		System.out.println(getTime(3));
		// System.out.println(a.substring(a.indexOf(":")));
	}
	
	public static List<String> getTime(int n) {
		List<String> result = new ArrayList<>();
		
		int hr = n;
		int min = 0;
		
		while (min <= n) {
			
			// count num of bits in hour
			ArrayList<String> hrList = new ArrayList<>(12);
			for (int i = 1; i < 13; i++) {
				
				if (Integer.bitCount(i) == hr) {
					String hour = Integer.toString(i);
					hrList.add(hour + ":00");
				}
			}
			hr--;
			
			// count num of bits in minute
			ArrayList<String> minList = new ArrayList<>(59);
			for (int i = 1; i < 60; i++) {
				
				if (Integer.bitCount(i) == min) {
					String minute = Integer.toString(i);
					
					if (i < 10) {
						minList.add("0:0" + minute);
					} else {
						minList.add("0:" + minute);
					}
				}
			}
			min++;
			
			// append hrList and minList to result list
			if (hrList.size() == 0 || minList.size() == 0) {
				result.addAll(hrList);
				result.addAll(minList);
				continue;
			}
			
			for (int i = 0; i < hrList.size(); i++) {
				
				for (int j = 0; j < minList.size(); j++) {
					String hrInFormat = hrList.get(i).substring(0, hrList.get(i).indexOf(":"));
					String minInFormat = minList.get(j).substring(minList.get(i).indexOf(":"));
					result.add(hrInFormat + minInFormat);
				}
			}
		}
		return result;
	}
}
