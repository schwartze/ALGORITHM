package algorithm;

public class DayOfYear {

	public static void main(String[] args) {
		String date = "2004-03-01";
		DayOfYear dYear = new DayOfYear();
		int res = dYear.dayOfYear(date);
		System.out.println(res);
	}
	
    public int dayOfYear(String date) {
    	String[] dateStr = date.split("-");
    	int year = Integer.parseInt(dateStr[0]);
    	int month = Integer.parseInt(dateStr[1]);
    	int dt = Integer.parseInt(dateStr[2]);
    	int res = 0, feb = isLeap(year) ? 1 : 0;
    	
    	int[] days = {31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    	
    	for (int i = 0; i < month - 1; i++) {
    		res += days[i];
    	}
    	return res + dt;
    }
    
    private boolean isLeap(int year) {
    	
    	if (year % 400 == 0)
    		return true;

    	if (year % 100 == 0)
    		return false;
    	
    	if (year % 4 == 0)
    		return true;
    	
    	return false;
    }
   
}
