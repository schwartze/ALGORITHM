package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DeploymentCount {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		int[] progresses2 = {95, 90, 99, 99, 80, 99};
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		
		int[] res = solution(progresses2, speeds2);
		
		for (int n : res)
			System.out.print(n + ", ");
	}
	
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] daysTakeToFinish = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
        	int progress = progresses[i];
        	int speed = speeds[i];
        	int daysTake = 0;
        	
        	while (progress < 100) {
        		progress += speed;
        		daysTake++;
        	}
        	daysTakeToFinish[i] = daysTake;
        }
        
        List<Integer> list = new ArrayList<>();
        int deployableTaskCount = 1, days = daysTakeToFinish[0]; 
        // 7, 3, 9
        
        for (int i = 1; i < daysTakeToFinish.length; i++) {
        	
        	if (daysTakeToFinish[i] <= days) {
            	deployableTaskCount++;
        	} else {
        		list.add(deployableTaskCount);
        		days = daysTakeToFinish[i];
        		deployableTaskCount = 1;
        	}
        	
        	if (i == daysTakeToFinish.length - 1) {
        		list.add(deployableTaskCount);
        	}
        	
        }
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }
}
