package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
	
	public static void main(String[] args) {
		
		
		BrowserHistory history2 = new BrowserHistory("leetcode.com");
		history2.visit("google.com");
		history2.visit("facebook.com");
		history2.visit("youtube.com");
		history2.back(1);
		history2.back(1);
		history2.forward(1);
		history2.visit("linkedin.com");
		history2.forward(2);
		history2.back(2);
		String res = history2.back(7);
		System.out.println(res);
		
	}

	List<String> histories;
	int at = 1;
	
    public BrowserHistory(String homepage) {
    	histories = new ArrayList<>();
    	histories.add(homepage);
    }
    
    public void visit(String url) {
    	if (at < histories.size()) {
    		histories = histories.subList(0, at);
    		at = histories.size();
    	}
    	histories.add(url);
    	at++;
    }
    
    public String back(int steps) {
    	if (steps >= at || steps >= histories.size()) {
    		at = 1;
    		return histories.get(at - 1);
    	}
    	at -= steps;
    	return histories.get(at - 1);
    }
    
    public String forward(int steps) {
    	if (steps + at > histories.size()) {
    		at = histories.size();
    		return histories.get(at - 1);
    	}
    	at += steps;
    	return histories.get(at - 1);
    }
}
