public class TrieNode {
    public final TrieNode[] children;
    public String item;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        item = "";
    }
    
    public TrieNode getChild(char c){
        if(c == '*')
            return null;
        int index = c - 'a';
        return children[index];
    }

    public void setChild(char c, TrieNode node){
    	int index = c - 'a';
        children[index] = node;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.getChild(c)== null) {
                curr.setChild(c, new TrieNode());
            }
            curr = curr.getChild(c);
        }
        curr.item = word;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.getChild(c) == null){
                return false;
            }else {
                curr = curr.getChild(c);
            }
        }
        return word.equals(curr.item);
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            if(curr.getChild(c)==null) {
                return false;
            }
            curr = curr.getChild(c);
        }
        return true;
    }
}