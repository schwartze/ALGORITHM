package algorithm;

public class SalaryCalculator {

	public static void main(String[] args) {
		int[] salary = {48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
		double res = average(salary);
		System.out.println(res);
	}
	
    public static double average(int[] salary) {
    	double max = 999, min = 100001, sum = 0;
    	
    	for (int sal : salary) {
    		sum += sal;
    		
    		if (sal > max)
    			max = sal;
    		
    		if (sal < min)
    			min = sal;
    	}
    	return (sum - min - max) / (salary.length - 2);
    }
}
