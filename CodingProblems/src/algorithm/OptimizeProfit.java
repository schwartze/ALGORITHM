package algorithm;

import java.util.Arrays;

public class OptimizeProfit {
	
	public static void main(String[] args) {
		Job job1 = new Job(2, 100);
		Job job2 = new Job(1, 19);
		Job job3 = new Job(2, 27);
		Job job4 = new Job(1, 25);
		Job job5 = new Job(3, 15);
		
		Job[] jobs = new Job[5];
		jobs[0] = job1;
		jobs[1] = job2;
		jobs[2] = job3;
		jobs[3] = job4;
		jobs[4] = job5;
		
		int res = getMaxProfit(jobs);
		System.out.println(res);
	}
	
	public static int getMaxProfit(Job[] jobs) {
		Arrays.sort(jobs, ((a, b) -> b.getProfit() - a.getProfit()));
		int[] timeSlot = new int[jobs.length];
		int maxProfit = 0;
		
		for (int i = 0; i < jobs.length; i++) {
			int deadline = jobs[i].getDeadline();

			for (int j = deadline - 1; j >= 0; j--) {
				
				if (timeSlot[j] == 0) {
					timeSlot[j]++;
					maxProfit += jobs[i].getProfit();
					break;
				}
			}
		}
		return maxProfit;
	}

}

class Job {
	
	private int deadline;
	private int profit;
	
	public Job(int deadline, int profit) {
		this.deadline = deadline;
		this.profit = profit;
	}

	public int getDeadline() {
		return deadline;
	}

	public int getProfit() {
		return profit;
	}

}