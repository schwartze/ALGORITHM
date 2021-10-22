package algorithm;

public class MergeLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(0);
		node1.next = new ListNode(1);
		node1.next.next = new ListNode(2);
		node1.next.next.next = new ListNode(3);
		node1.next.next.next.next = new ListNode(4);
		node1.next.next.next.next.next = new ListNode(5);
		int a = 3, b = 4;
		
		ListNode node2 = new ListNode(1000000);
		node2.next = new ListNode(1000001);
		node2.next.next = new ListNode(1000003);
		
		ListNode res = mergeInBetween2(node1, a, b, node2);
		
		while (res != null) {
			System.out.print(res.val + ", ");
			res = res.next;
		}
	}
	
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
    	ListNode start = list1;
    	ListNode end = list1;
    	int idx = 0;
    	
    	while (idx++ < b) {
    		if (idx < a) 
    			start = start.next;
    		end = end.next;
    	}
    	start.next = list2;
    	ListNode temp = start.next;
    	while (temp.next != null) {
    		temp = temp.next;
    	}
    	temp.next = end.next;
    	
    	return list1;
    }


    public static ListNode mergeInBetween2(ListNode list1, int a, int b, ListNode list2) {
    	ListNode curr = list1.next;
    	ListNode prev = list1;
    	boolean removable = false;
    	
    	while (curr != null) {
    		
    		if (curr.val == a) {
    			prev.next = list2;
    			while (prev.next != null) {
    				prev = prev.next;
    	    	}
    			removable = true;
    		}
    		
    		if (curr.val == b) {
    			prev.next = curr.next;
    			break;
    		}
    		
    		if (!removable) {
    			prev = prev.next;
    		}
    		curr = curr.next;
    	}
    	
    	return list1;
    }
}
