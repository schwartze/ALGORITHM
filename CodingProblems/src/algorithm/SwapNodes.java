package algorithm;

public class SwapNodes {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		
		ListNode res = swapPairs(head);
		
		while (res != null) {
			System.out.println(res.val);
			res = res.next;
		}
			
	}

    public static ListNode swapPairs(ListNode head) {
    	ListNode curr = head;

    	while (curr != null) {
        	ListNode temp = curr;
    		ListNode next = curr.next;
    		ListNode rest = null;
    		
    		if (next.next != null)
    			rest = next.next;
    		
    		curr = next;
    		curr.next = temp;
    		temp.next = rest;
    	}
    	return head;
    }
}
