package algorithm;

public class RemoveNode {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(1);
		
		removeDupNodes(head);
		
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static void removeDupNodes(ListNode head) {
		
		while (head != null) {
			ListNode node = head;
			int val = node.val;
			
			while (node != null && node.next != null) {
				
				if (val == node.next.val) {
					
					if (node.next.next == null) 
						node.next = null;
					else 
						node.next = node.next.next;
				}
				node = node.next;
			}
			head = head.next;
		}
	}
}
