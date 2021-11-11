package algorithm;

public class AddTwoNumbers {
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int num1 = getListNodes(l1);
    	int num2 = getListNodes(l2);
    	
    	int sum = num1 + num2;
    	ListNode result = null;
    	ListNode temp = result;
    	
    	while (true) {
    		int firstPlaceValue = sum % 10;
    		sum /= 10;
    		
    		if (temp == null) {
    			result = new ListNode(firstPlaceValue);
    			temp = result;
    		} else {
    			temp.next = new ListNode(firstPlaceValue);
    		}
    		temp = temp.next;
    		if (sum == 0)
    			break;
    	}
    	return result;
    }
    
    private int getListNodes(ListNode list) {
    	StringBuilder sb = new StringBuilder();
    	
    	while (list != null) {
    		sb.append(list.val);
    		list = list.next;
    	}
    	
    	return Integer.parseInt(sb.reverse().toString());
    }
}
