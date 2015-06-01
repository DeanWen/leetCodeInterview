/*
Solution 1
DFS + Trie
Use Word Search as Sub Routine 
*/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words)
            trie.insert(word);
        List<String> result = new ArrayList<String>();
        for(int i= 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j++)
                findWords(result, board, i, j, trie.root);
        return result;
    }
    public void findWords(List<String> result,char[][] board, int i, int j, TrieNode node){
        if(!node.item.equals("")){
            result.add(node.item);
            node.item = "";
        }
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1) return;
        if(node.getChild(board[i][j])==null){
            return;
        }
        char c = board[i][j];
        board[i][j] = '*';
        node = node.getChild(c);
        findWords(result, board, i, j-1, node);
        findWords(result, board, i, j+1, node);
        findWords(result, board, i-1, j, node);
        findWords(result, board, i+1, j, node);
        board[i][j] = c;
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
    public class Trie {
        private TrieNode root;
    
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String word) {
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                if(curr.getChild(c)== null)
                    curr.setChild(c, new TrieNode());
                curr = curr.getChild(c);
            }
            curr.item = word;
        }
        public boolean search(String word) {
            TrieNode curr = root;
            for(char c: word.toCharArray()){
                if(curr.getChild(c) == null)
                    return false;
                else
                    curr = curr.getChild(c);
            }
            return word.equals(curr.item);
        }
    
        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for(char c: prefix.toCharArray()){
                if(curr.getChild(c)==null)
                    return false;
                curr = curr.getChild(c);
            }
            return true;
        }
    }
}


/*
Solution 2
DFS
Use Word Search as Sub Routine 
*/
public class Solution {
	public static List<String> findWords(char[][] board, String[] words) {
		List<String> list = new ArrayList<String>();
		if (board == null || board.length == 0 || board[0].length == 0
				|| words.length == 0) {
			return list;
		}

		for (String w : words) {
			exist(board, w, list);
		}

		return list;
	}

	public static void exist(char[][] board, String word, List<String> list) {
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				helper(board, i, j, word, 0, visited, list);
			}
		}
	}

	public static boolean helper(char[][] board, int i, int j, String word, int start,
			boolean[][] visited, List<String> list) {
		if (start == word.length()) {
			list.add(word);
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
			return false;
		}
		if (board[i][j] != word.charAt(start)) {
			return false;
		}
		if (visited[i][j]) {
			return false;
		}

		visited[i][j] = true;
		boolean result = helper(board, i + 1, j, word, start + 1, visited, list)
				|| helper(board, i - 1, j, word, start + 1, visited, list)
				|| helper(board, i, j + 1, word, start + 1, visited, list)
				|| helper(board, i, j - 1, word, start + 1, visited, list);
		visited[i][j] = false;
		return result;
	}

	public static void main(String[] args) {
		String[] words = { "oath", "pea", "eat", "rain" };
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' },
				{ 'i', 'h', 'k', 'r' }, { 'i', 'f', 'l', 'v' } };
		
		List<String> res = findWords(board, words);
		for (String s : res) {
			System.out.println(s);
		}
	}
}