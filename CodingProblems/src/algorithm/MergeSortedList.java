package algorithm;

public class MergeSortedList {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(2);
		l2.next.next = new ListNode(3);
		l2.next.next.next = new ListNode(4);
		
		mergeTwoLists(l1, l2);
	}

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode curr1 = l1;
    	ListNode curr2 = l2;
    	
    	while (curr1.next != null) {
    		ListNode temp = null;
        	
    		if (curr1.val <= curr2.val && curr1.next.val > curr2.val) {
        		temp = curr1.next;
        		curr1.next = curr2;
        		curr2 = temp;
        	}
    		curr1 = curr1.next;
    	}
    	curr1.next = curr2;
    	return l1;
    }
}
