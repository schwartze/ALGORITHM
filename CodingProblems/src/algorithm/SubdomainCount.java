package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainCount {

	public static void main(String[] args) {
		String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

		SubdomainCount subdomain = new SubdomainCount();
		List<String> res = subdomain.subdomainVisits(cpdomains);
		
		for (String s : res) 
			System.out.println(s);
	}
	
    public List<String> subdomainVisits(String[] cpdomains) {
     
    	Map<String, Integer> map = new HashMap<>();
    	
    	for (String domain : cpdomains) {
    		
    		String[] domInfo = domain.split(" ");
    		map.put(domInfo[1], Integer.parseInt(domInfo[0]));
    	}
    	
    	Object[] keyArr = map.keySet().toArray();
    	
    	for (int i = 0; i < keyArr.length; i++) {

			StringBuffer temp = new StringBuffer((String)keyArr[i]);
    		
			while (temp.indexOf(".") != -1) {
				String upperDom = temp.substring(temp.indexOf(".") + 1, temp.length());

				if (map.containsKey(upperDom)) 
					map.put(upperDom, map.get(upperDom) + map.get((String)keyArr[i]));
				else
					map.put(upperDom, map.get(temp.toString()));
				temp = new StringBuffer(upperDom);
			}

    	}
    	
    	List<String> res = new ArrayList<>(map.size());
    	
    	for (String dom : map.keySet()) {
    		StringBuffer domWithCount = new StringBuffer();
    		domWithCount.append(map.get(dom));
    		domWithCount.append(" ");
    		domWithCount.append(dom);
    		res.add(domWithCount.toString());
    	}
    	
    	return res;
    }
}
