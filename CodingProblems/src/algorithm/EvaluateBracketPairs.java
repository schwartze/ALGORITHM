package algorithm;

import java.util.ArrayList;
import java.util.List;

public class EvaluateBracketPairs {
	
	public static void main(String[] args) {
		String s = "hi(name)";
		List<String> pair1 = new ArrayList<>();
		pair1.add("a");
		pair1.add("b");
		
//		List<String> pair2 = new ArrayList<>();
//		pair2.add("age");
//		pair2.add("two");
		
		List<List<String>> knowledge = new ArrayList<List<String>>();
		knowledge.add(pair1);
//		knowledge.add(pair2);
		
		String res = evaluate(s, knowledge);
		System.out.println(res);
	}

    public static String evaluate(String s, List<List<String>> knowledge) {
    	
    	for (int i = 0; i < knowledge.size(); i++) {
    		List<String> pair = knowledge.get(i);
    		
    		String target = "\\(" + pair.get(0) + "\\)";
    		s = s.replaceAll(target, pair.get(1));
    	}
    	
    	int idx = 0;
    	while (s.indexOf("(", idx) >= 0) {
    		
    		int firstIdx = s.indexOf("(", idx);
    		int secondIdx = s.indexOf(")", firstIdx);
    		
    		String target = s.substring(firstIdx + 1, secondIdx);
    		s = s.replaceAll("\\(" + target + "\\)", "?");
    	}
    	return s;
    }
}
