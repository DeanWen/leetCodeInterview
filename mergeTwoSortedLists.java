//Merge Two Sorted List
public class Solution{
	public ListNode mergeTwoLists(ListNode head1, ListNode head2){
		ListNode dummyNode = new ListNode(0);
		ListNode tail = dummyNode;

		while(head1.val != null && head2.val != null){
			if (head1 < head2){
				tail.next = head1;
				head1 = head1.next;
			}else{
				tail.next = head2;
				head2 = head2.next;
			}
			tail = tail.next;
		}

		if (head1 != null){
			tail.next = head1;
		}else{
			tail.next = head2;
		}
	return dummyNode.next;
	}
}