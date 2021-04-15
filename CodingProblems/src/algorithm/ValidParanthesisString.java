package algorithm;

import java.util.Stack;

public class ValidParanthesisString {

	public static void main(String[] args) {
		String s = "{}([])";
		
		ValidParanthesisString vps = new ValidParanthesisString();
		
		int res = vps.solution(s);
		System.out.println(res);
	}
	
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        
        int idx = 0;
        while (idx++ < s.length()) {
        	if (isValid3(sb.toString()))
        		answer++;
        	char c = sb.charAt(0);
        	sb.append(c);
        	sb.deleteCharAt(0);
        }
        
        return answer;
    }
    
    private boolean isValid3(String s) {
    	String temp = s;
    	int idx = 0;
    	
    	while (idx++ < 3 && temp.length() > 0) {
    		temp = temp.replaceAll("\\(\\)", "");
    		temp = temp.replaceAll("\\{\\}", "");
    		temp = temp.replaceAll("\\[\\]", "");
    	}
    	return temp.length() == 0;
    }
    
    private boolean isValid2(String s) {
    	Stack<Character> stack = new Stack<>();
    	int left = 0;
    	
    	if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']')
    		return false;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		
    		if (c == '(' || c == '{' || c == '[') {
    			left++;
    			stack.push(c);
    			continue;
    		}
    		
    		while (!stack.isEmpty()) {
    			char last = stack.peek();
    			
    			if (last == '(' && c == ')') {
    				left--;
    				stack.pop();
    			} else if (last == '{' && c == '}') {
    				left--;
    				stack.pop();
    			} else if (last == '[' && c == ']') {
    				left--;
    				stack.pop();
    			} else {
    				break;
    			}
    		}
    	}
    	return stack.isEmpty() && left == 0;
    }
    
    private boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	int smallCnt = 0, medCnt = 0, largeCnt = 0;
    	
    	if (s.charAt(0) == '}' || s.charAt(0) == ')' || s.charAt(0) == ']')
    		return false;
    	
    	for (int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		
    		if (c == '(') {
    			smallCnt++;
    			stack.push(c);
    			continue;
    		}
    		else if (c == '{') {
    			medCnt++;
    			stack.push(c);
    			continue;
    		} else if (c == '[') {
    			largeCnt++;
    			stack.push(c);
    			continue;
    		}
    		
    		while (!stack.isEmpty()) {
    			char last = stack.peek();
    			
    			if (last == '(' && c == ')') {
    				smallCnt--;
    				stack.pop();
    			} else if (last == '{' && c == '}') {
    				medCnt--;
    				stack.pop();
    			} else if (last == '[' && c == ']') {
    				largeCnt--;
    				stack.pop();
    			} else {
    				break;
    			}
    		}
    	}
    	return stack.isEmpty() && smallCnt == 0 && medCnt == 0 && largeCnt == 0;
    }
}
