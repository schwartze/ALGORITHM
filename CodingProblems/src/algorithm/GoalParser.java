package algorithm;

public class GoalParser {

	public static void main(String[] args) {
		String command = "G()()()(al)";
		String res = interpret(command);
		System.out.println(res);
	}
	// given words are consist of G, () or (al), then replace the followings:  
	// 1. (al) with al 
	// 2. () with o
    public static String interpret(String command) {
    	return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }
}
