/*
Difference among 
HashSet HashMap HashTable

HashSet only store the object: add() hasCode() equals()
	can not store duplicate object
HashMap store <key, object> : put() get() containsKey() 
	can store duplicate value iff key is different
HashTable almost same with HashMap, but is syncronized and not accept null value.
*/

public class HashEntry {
	private int key;
	private int value;
	
	HashEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return this.key;
	}

	public int getValue() {
		return this.value;
	}
}

public class HashTable {
	private final static int TABLE_SIZE = 128;

	HashEntry[] table;

	HashTable () {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE ; i++) {
			table[i] = null;
		}
	}

	public int get (int key) {
		int hash = key % TABLE_SIZE;

		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}

		if (table[hash] == null) {
			return -1;
		}else {
			return table[hash].getValue();
		}
	}

	public void put (int key, int value) {
		int hash = key % TABLE_SIZE;
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}
		table[hash] = new HashEntry(key, value);
	}
}