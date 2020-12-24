package algorithm;

public class ParkingSystem {

	private int big;
	private int medium;
	private int small;
	
    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }
    
    public boolean addCar(int carType) {
    	boolean isAvailable = false;
    	
    	if (carType == 1 && big > 0) {
    		big--;
    		isAvailable = true;
    	} else if (carType == 2 && medium > 0) {
    		medium--;
    		isAvailable = true;
    	} else if (carType == 3 && small > 0) {
    		small--;
    		isAvailable = true;
    	}
    	
    	return isAvailable;
    }
    
}
