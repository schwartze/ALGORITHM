package algorithm;

public class DefaningIP {

	public static void main(String[] args) {
		String address = "1.1.1.1";
		
		String res = defangIPaddr(address);
		System.out.println(res);
	}
	
    public static String defangIPaddr(String address) {
    	
    	return address.replaceAll("\\.", "[.]");
    }
}
