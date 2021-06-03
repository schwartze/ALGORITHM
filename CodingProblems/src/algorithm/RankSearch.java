package algorithm;

import java.util.ArrayList;
import java.util.List;

public class RankSearch {
	
	public static void main(String[] args) {
		String[] info = {
				"java backend junior pizza 150", 
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"
				};
		
		String[] queries = {
				"java and backend and junior and pizza 100", 
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		
		RankSearch search = new RankSearch();
		int[] result = search.solution(info, queries);
		
		for (int n : result)
			System.out.print(n + ", ");
	}
	
    public int[] solution(String[] info, String[] queries) {
        int[] answer = new int[queries.length];
        
        List<Applicant> list = new ArrayList<>();
        
        for (String information : info) {
        	String[] applicantInfo = information.split(" ");
        	
        	Applicant applicant = new Applicant(applicantInfo[0], applicantInfo[1], applicantInfo[2], applicantInfo[3], applicantInfo[4]);
        	list.add(applicant);
        	System.out.println(applicant);
        }
        
        for (int i = 0; i < queries.length; i++) {
        	int applicantCount = 0;
        	String[] conditions = queries[i].replaceAll(" and", "").split(" ");
        	
        	for (int j = 0; j < list.size(); j++) {
        		Applicant applicant = list.get(j);
        		
        		if (applicant.applicable(conditions))
        			applicantCount++;
        	}
        	
        	answer[i] = applicantCount;
        }
        return answer;
    }
    
    class Applicant {
    	private String language;
    	private String position;
    	private String level;
    	private String food;
    	private int score;
    	
    	public Applicant(String language, String position, String level, String food, String score) {
    		this.language = language;
    		this.position = position;
    		this.level = level;
    		this.food = food;
    		this.score = Integer.parseInt(score);
    	}
    	
    	public boolean applicable(String[] condition) {
    		String givenLanguage = condition[0];
    		String givenPosition = condition[1];
    		String givenLevel = condition[2];
    		String givenFood = condition[3];
    		int givenScore = Integer.parseInt(condition[4]);
    		
    		if (!givenLanguage.equals("-") && !givenLanguage.equals(language))
    			return false;
    		
    		if (!givenPosition.equals("-") && !givenPosition.equals(position))
    			return false;
    		
    		if (!givenLevel.equals("-") && !givenLevel.equals(level))
    			return false;
    		
    		if (!givenFood.equals("-") && !givenFood.equals(food))
    			return false;
    		
    		if (givenScore > score)
    			return false;
    		
    		return true;
    	}

		@Override
		public String toString() {
			return "Applicant [language=" + language + ", position=" + position + ", level=" + level + ", food=" + food
					+ ", score=" + score + "]";
		}
    	
    }
}
