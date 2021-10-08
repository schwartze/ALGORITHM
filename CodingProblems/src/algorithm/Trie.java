package algorithm;

import java.util.Set;
import java.util.TreeSet;

public class Trie {

	Set<String> trieSet;
	
    public Trie() {
        trieSet = new TreeSet<>();
    }
    
    public void insert(String word) {
        trieSet.add(word);
    }
    
    public boolean search(String word) {
    	return trieSet.contains(word);
    }
    
    public boolean startsWith(String prefix) {
    	return trieSet.stream().anyMatch(s -> s.startsWith(prefix));
    }
}
