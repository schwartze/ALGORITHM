package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UndergroundSystem {

	Map<Integer, Passenger> passengerMap;
	Map<Integer, Journey> journeyMap;
	
	public UndergroundSystem() {
        passengerMap = new HashMap<>();
        journeyMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        passengerMap.put(id, new Passenger(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Passenger passenger = passengerMap.get(id);
        passenger.exit(stationName, t);
        
        int key = Objects.hash(passenger.fromStation, passenger.toStation);
        
        if (!journeyMap.containsKey(key)) {
        	journeyMap.put(key, new Journey());
        }
        
        Journey journey = journeyMap.get(key);
        journey.addJourney(passenger.boardingTime, passenger.boardingTime);
        passengerMap.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	int key = Objects.hash(startStation, endStation);
    	Journey journey = journeyMap.get(key);
    	
    	return journey.getJourneyAverage();
    }
}

class Passenger {
	String fromStation;
	String toStation;
	int boardingTime;
	int exitTime;
	
	public Passenger(String fromStation, int boardingTime) {
		this.fromStation = fromStation;
		this.boardingTime = boardingTime;
	}
	
	public void exit(String toStation, int exitTime) {
		this.toStation = toStation;
		this.exitTime = exitTime;
	}
}

class Journey {
	int count;
	int time;
	
	public Journey() {
		count = 0;
		time = 0;
	}
	
	public void addJourney(int boardingTime, int exitTime) {
		count++;
		time += exitTime - boardingTime;
	}
	
	public double getJourneyAverage() {
		
		return (double) time / (double) count;
	}
}
