import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    public Integer get(Object key) {
        Integer v = super.get(key);
        if (v != null)
            return v;
        else
            return -1;
    }

    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public void set(int key, int value) {
        super.put(key, value);
    }
}



public class LRUCache {
    private class Node {
        Node prev;
        Node next;
        int key;
        int value;
    
    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
    }

    private int capacity;
    private HashMap<Integer, Node> hs = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!hs.containsKey(key)) {
            return -1;
        }

        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        moveToEnd(current);

        return hs.get(key).value;
    }

    public void set(int key, int value) {
        if (get(key) != -1) {
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity) {
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key, value);
        hs.put(key,insert);
        moveToEnd(insert);
    }

    private void moveToEnd(Node current) {
        current.prev = tail.prev;
        tail.prev = current;
        current.prev.next = current;
        current.next = tail;
    }
}