package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DestinationCity {

	public static void main(String[] args) {
//		List<String> path1 = new ArrayList<>();
//		path1.add("London");
//		path1.add("New York");
//		
//		List<String> path2 = new ArrayList<>();
//		path2.add("New York");
//		path2.add("Lima");
//		
//		List<String> path3 = new ArrayList<>();
//		path3.add("Lima");
//		path3.add("San Paulo");

		List<String> path1 = new ArrayList<>();
		path1.add("B");
		path1.add("C");
		
		List<String> path2 = new ArrayList<>();
		path2.add("D");
		path2.add("B");
		
		List<String> path3 = new ArrayList<>();
		path3.add("C");
		path3.add("A");		
		
		List<List<String>> paths = new ArrayList<>();
		paths.add(path1);
		paths.add(path2);
		paths.add(path3);
		
//		String res = destCity(paths);

		DestinationCity dCity = new DestinationCity();
		String res = dCity.destCityUsingSort(paths);
		
		System.out.println(res);
	}
	
	// You are given the array paths, where paths[i] = [cityAi, cityBi] means 
	// there exists a direct path going from cityAi to cityBi. 
	// Return the destination city, that is, the city without any path outgoing 
	// to another city.

	// It is guaranteed that the graph of paths forms a line without any loop, 
	// therefore, there will be exactly one destination city.

    public static String destCity(List<List<String>> paths) {
    	List<String> startingCities = new ArrayList<>();
    	String desCity = "";
    	
    	for (List<String> path : paths)
    		startingCities.add(path.get(0));
    		
    	for (List<String> path : paths) {
    		if (startingCities.contains(path.get(1)))
    			continue;
    		desCity = path.get(1);
    	}
    	return desCity;
    }
    
    public String destCityUsingSort(List<List<String>> paths) {
    	paths.sort(new sortByPath());
    	return paths.get(paths.size() - 1).get(1);
    }
}

class sortByPath implements Comparator<List<String>> {

	@Override
	public int compare(List<String> path1, List<String> path2) {

		if (path1.get(0).contentEquals(path2.get(1)))
			return 1;
		
		if (path1.get(1).contentEquals(path2.get(0)))
			return -1;
			
		return 0;
	}
}

