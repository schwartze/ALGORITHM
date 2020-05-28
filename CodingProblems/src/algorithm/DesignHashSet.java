package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignHashSet {

	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		
		boolean res1 = hashSet.contains(2);
		boolean res2 = hashSet.contains(3);

		System.out.println(res1 + ", " + res2 );
	}
}

class MyHashSet {
	
	boolean[] arr = new boolean[100];
	
    /** Initialize your data structure here. */
    public MyHashSet() {
    }
    
    public void add(int key) {
    	
    	if (key > arr.length)
    		extend(key);
    	
    	arr[key] = true;
    }
    
    public void remove(int key) {

    	if (key > arr.length)
    		return;
    	
    	arr[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	
    	return arr[key];
    }
    
    private void extend(int key) {
    	arr = Arrays.copyOf(arr, key + 2);
    }
}

