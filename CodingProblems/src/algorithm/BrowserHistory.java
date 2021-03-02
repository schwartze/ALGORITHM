package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory {
	
	public static void main(String[] args) {
		/*
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
		history2.back(7);
		*/

		BrowserHistory history3 = new BrowserHistory("esgriv.com");
		history3.visit("cgrt.com");
		history3.visit("tips.com");
		history3.back(9);
		history3.visit("kttzxgh.com");
		history3.forward(7);
		history3.visit("crqje.com");
		history3.visit("iybch.com");
		history3.forward(5);
		history3.visit("uun.com");
		history3.back(10);
		history3.visit("hci.com");
		history3.visit("whula.com");
		history3.forward(10);
		
		
		/*
		BrowserHistory history = new BrowserHistory("rlglu.com");
		history.back(2);
		history.visit("zxowmd.com");
		history.back(4);
		history.visit("gbnssie.com");
		history.visit("bqo.com");
		history.back(6);
		history.visit("cq.com");
		history.visit("pbh.com");
		history.back(5);
		history.visit("ijt.com");
		history.visit("tnsiso.com");
		history.forward(7);
		history.visit("xjxi.com");
		history.forward(3);
		history.forward(9);
		history.visit("zlnx.com");
		history.forward(3);
		history.forward(7);
		*/
	}

	List<String> histories;
	int currentAt = 0;
	
    public BrowserHistory(String homepage) {
    	histories = new ArrayList<>();
    	visit(homepage);
    }
    
    public void visit(String url) {
    	if (currentAt < histories.size()) {
        	histories.set(currentAt, url);
        	currentAt++;
        	return;
    	}
    	
    	histories.add(url);
    	currentAt++;
    }
    
    public String back(int steps) {
        if (histories.size() - steps <= 0) {
        	currentAt = 1;
        	histories = histories.subList(0, currentAt);
        	System.out.println(histories.get(0));
        	return histories.get(0);
        }
        
    	currentAt -= steps;
    	System.out.println(histories.get(currentAt - 1));
    	return histories.get(currentAt - 1);
    }
    
    public String forward(int steps) {
        if (currentAt + steps > histories.size()) {
        	System.out.println(histories.get(histories.size() - 1));
        	return histories.get(histories.size() - 1);
        }
        
    	currentAt += steps;
    	System.out.println(histories.get(currentAt - 1));
    	return histories.get(currentAt - 1);
    }
}
