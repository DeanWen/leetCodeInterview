import java.util.*;

public class LRUCache {
    
    public Entry head = null;
    Entry tail = null;
    Map<Integer,Entry> mapping = new HashMap<Integer,Entry>();
    int currentSize = 0;
    int cap;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(mapping.containsKey(key)){
            Entry node = mapping.get(key);
            removeTohead(node);
            return node.val;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(mapping.containsKey(key)){
        	Entry node = mapping.get(key);
            node.val = value;
            this.removeTohead(node);
        }else{
            Entry entry = new Entry(key,value);
            if(currentSize == 0){
                head = entry;
                tail = entry;
                mapping.put(key,entry);
                currentSize++;
                return;
            }
            currentSize++;
            if(currentSize-1 >= cap){
                removetail();
                currentSize = cap;
            }
            addtoFront(entry);
            mapping.put(key,entry);
        }
    }
    
    public void removetail(){
        mapping.remove(tail.key);
        if(tail == head){
            head = null;
            tail = null;
        }else{
            tail = tail.pre;
            tail.next = null;
        }
    }
    
     public void addtoFront(Entry node){
	        if(head == null && tail == null){
	        	head = node;
	        	tail = node;
	        	return;
	        }
	        node.next = head;
	        head.pre = node;
	        node.pre = null;
	        if(head.next == null) tail = head;
	        head = node;
	    }
	    
    public void removeTohead(Entry node){
        if(node == head) return;
        node.pre.next = node.next;
        if(node.next == null){
            tail = node.pre;
        }else{
            node.next.pre = node.pre;
        }
        node.next = head;
        node.pre = null;
        head.pre = node;
        head = node;
    }
    
    public void print(){
    	Entry node = head;
    	while(node!=null){
    		System.out.print(node.key + "->");
    		node = node.next;
    	}
    	System.out.println();
    	Entry node2 = tail;
    	while(node2!=null){
    		System.out.print(node2.key + "->");
    		node2 = node2.pre;
    	}
    	System.out.println();
    }
    public class Entry{
        Entry pre;
        Entry next;
        int val;
        int key;
        
        public Entry(int key, int val){
            pre = null;
            next = null;
            this.val = val;
            this.key = key;
        }
    }
}