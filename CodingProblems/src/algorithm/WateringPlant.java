package algorithm;

public class WateringPlant {
	
	public static void main(String[] args) {
		int[] plants = {2, 2, 3, 3};
		int capacity = 5;
		
		int[] plants2 = {1, 1, 1, 4, 2, 3};
		int capacity2 = 4;
		
		int[] plants3 = {7, 7, 7, 7, 7, 7, 7};
		int capacity3 = 8;
		
		int res = wateringPlants(plants3, capacity3);
		System.out.println(res);
	}

    public static int wateringPlants(int[] plants, int capacity) {
    	int steps = 0;
    	int currCapacity = capacity;
    	
    	for (int i = 0; i < plants.length; i++) {
    		
    		if (plants[i] > currCapacity) {
    			steps += i + i + 1;  
    			currCapacity = capacity - plants[i]; 
    		} else {
    			steps++;
    			currCapacity -= plants[i];
    		}
    	}
    	return steps;
    }
}
