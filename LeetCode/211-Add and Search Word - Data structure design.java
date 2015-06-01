public class WordDictionary {
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.getChild(c) == null) {
                curr.setChild(c, new TrieNode());
            }
            curr = curr.getChild(c);
        }
        curr.item = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int index, TrieNode node) {
        if (index == chs.length) { 
            return !node.item.equals("");
        }   
        if (chs[index] != '.') {
            return node.children[chs[index] - 'a'] != null && match(chs, index + 1, node.children[chs[index] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, index + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
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
            return children[c-'a'];
        }
        public void setChild(char c, TrieNode node){
            children[c-'a'] = node;
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");