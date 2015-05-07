public class makeHuffmanTree(Node[] nodes) {
	PriorityQueue<Node> pq = new PriorityQueue<Node>();
	for (Node node : nodes) {
		pq.offer(node);
	}

	Node root = null;
	while (pq.size() > 1) {
		Node least1 = pq.poll();
		Node least2 = pq.poll();

		Node combined = new Node(least1.frequency + least2.frequency);
		combined.left = least1;
		combined.right = least2;
		
		pq.offer(combined);
		root = combined;
	}

	return root;
}