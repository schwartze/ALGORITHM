package algorithm;

public class LeetcodeBank {

	public static void main(String[] args) {
		int n = 4;
		int money = totalMoney(n);
		System.out.println(money);
	}
	
	/*
	 * Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
	 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
	 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
	 */
    public static int totalMoney(int n) {
    	int monday = 1, money = monday, total = money, daysLeft = 1;
    	
    	while (daysLeft++ < n) {
    		if (daysLeft % 7 == 1) {
    			monday++;
    			money = monday;
    			total += money;
    			continue;
    		}
    		money++;
    		total += money;
    	}
    	return total;
    }
}
