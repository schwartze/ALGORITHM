package algorithm;

public class BusStop {

	public static void main(String[] args) {
		int[] distance = {3, 6, 7, 2, 9, 10, 7, 16, 11};
		int start = 6, destination = 2;
		
		BusStop bStop = new BusStop();
		int res = bStop.distanceBetweenBusStops(distance, start, destination);
		System.out.println(res);
	}
	/*
	 * A bus has n stops numbered from 0 to n - 1 that form a circle. 
	 * We know the distance between all pairs of neighboring stops where 
	 * distance[i] is the distance between the stops number i and (i + 1) % n.
	 * The bus goes along both directions i.e. clockwise and counterclockwise.
	 * Return the shortest distance between the given start and destination stops.
	 */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    	int sum = 0, path = 0;
    	for (int d : distance)
    		sum += d;
    	
    	for (int i = Math.min(start, destination); i < Math.max(start, destination); i++) {
    		path += distance[i];
    	}
    	return Math.min(path, sum - path);
    }
}
