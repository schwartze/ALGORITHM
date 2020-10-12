package algorithm;

public class BinaryToInteger {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(0);
		head.next.next = new ListNode(1);
		
		BinaryToInteger bToInt = new BinaryToInteger();
		int res = bToInt.getDecimalValue(head);
		System.out.println(res);
	}
	
    public int getDecimalValue(ListNode head) {
    	ListNode node = head;
    	int res = 0;
    	
    	while (node != null) {
    		res = (res << 1) | node.val;
    		node = node.next;
    	}
    	return res;
    }
}
