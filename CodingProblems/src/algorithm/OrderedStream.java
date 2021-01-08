package algorithm;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {
	
	public static void main(String[] args) {
		OrderedStream os = new OrderedStream(5);
		List<String> list3 = os.insert(3, "cccc");
		List<String> list1 = os.insert(1, "aaaa");
		List<String> list2 = os.insert(2, "bbbb");
		List<String> list5 = os.insert(5, "eeee");
		List<String> list4 = os.insert(4, "dddd");

		for (String s : list3)
			System.out.println(s);

		for (String s : list1)
			System.out.println(s);

		for (String s : list2)
			System.out.println(s);

		for (String s : list5)
			System.out.println(s);

		for (String s : list4)
			System.out.println(s);
	}
	
	String[] streamArray;
	int[] ptr = {0};
	
    public OrderedStream(int n) {
        streamArray = new String[n];
    }
    
    public List<String> insert(int id, String value) {
    	streamArray[id - 1] = value;
    	List<String> list = new ArrayList<>();
    	
    	if (ptr[0] == id - 1) {
    		for (int i = id - 1; i < streamArray.length; i++) {
    			if (streamArray[i] == null)
    				break;
    			list.add(streamArray[i]);
    			ptr[0]++;
    		}
    	} 
    	return list;
    }
}
