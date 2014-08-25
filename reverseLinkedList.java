//Reverse A Linked List with Two methods
//1st non recursion 

public Node reverseLinkedList(Node head){

	Node prev = null;
	Node curr = head;

	while (curr != null) {
		Node temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
	}

	return prev;
}

//2nd recursion -- Does not understand!WFT

public Node reverseLinkedList(Node curr, Node prev) {
	if (curr.next == null) {
		curr.next = prev;
		return curr;
	}else {
		Node temp = reverseLinkedList(curr.next, curr);
		curr.next = prev;
		return temp;
	}
}