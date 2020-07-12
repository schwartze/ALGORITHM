package algorithm;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		
		MiddleOfLinkedList mLinkedList = new MiddleOfLinkedList();
		ListNode res = mLinkedList.middleNode(head);
		System.out.println(res.val);
	}
	
	
    public ListNode middleNode(ListNode head) {
    	ListNode midNode = null;
    	
    	// get the size of listNode
    	int size = 0;
    	ListNode temp = head;
    	while (true) {
    		
    		if (temp.next == null)
    			break;
    		temp = temp.next;
    		size++;
    	}
    	
    	// find if the size is even/odd
    		// if even, the node to return is located at (size / 2) + 1
    	int mid = size / 2;
    	if (size % 2 != 0)
    		mid++;
    	
    	// return the node located at size / 2 or size / 2 + 1
    	ListNode tNode = head;
    	for (int i = 0; i < mid; i++) {
    		tNode = tNode.next;
    		midNode = tNode;
    	}
    	
    	return midNode;
    }
}
