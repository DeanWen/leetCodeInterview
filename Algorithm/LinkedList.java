/* Linked List Data Structure*/
/* Define the node*/
public class Node {
	private String element;
	private Node nextNode;

	Node(String content) {
		element = content;
		nextNode = null;
	}

	public void setElement(String content) {
		element = content;
	}

	public void setNextNode(Node newNode) {
		nextNode = newNode;
	}

	public String getElement() {
		return element;
	}

	public Node getNextNode() {
		return nextNode;
	}
}

/*
 * Single Linked List
 */
public class LinkedList {
	protected Node head;
	protected int size;

	LinkedList() {
		head = null;
		size = 0;
	}
	
	public Node getHead(){
		return head;
	}
	
	public void addFirst(Node newNode) {
		newNode.setNextNode(head);
		head = newNode;
		size = size + 1;
	}

	public void addLast(Node newNode) {
		if (size == 0) {
			head = newNode;
		}else {
			Node currentNode = head;
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(newNode);
			currentNode = null;
			}
		size = size + 1;
	}

	public void removeFirst() {
		if (size == 0) {
			System.out.println("Empty");
		} else{
			head = head.getNextNode();
			size = size - 1;
		}

	}

	public void removeLast() {
		if (size == 0) {
			System.out.println("Empty");
		}else if (size == 1) {
			head = null;
		}else {
			Node currentNode = head;
			Node prevNode = null;
			while (currentNode.getNextNode() != null) {
				prevNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			prevNode.setNextNode(null);
			size = size - 1;
		}
	}
}
