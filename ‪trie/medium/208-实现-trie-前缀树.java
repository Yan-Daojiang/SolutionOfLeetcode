/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {
    class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;


    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        if (word == null)
            return;
        
        char[] words = word.toCharArray();
        for (char ch : words) {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            
            node = node.children[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        if (word == null || word.length() == 0)
            return true;

        char[] words = word.toCharArray();
        
        for (char ch : words) {
            if (node.children[ch - 'a']  == null)
                return false;

            node = node.children[ch - 'a'];
        }
        return node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        if (prefix == null || prefix.length() == 0)
            return true;

        char[] pres = prefix.toCharArray();

        for (char ch : pres) {
            if (node.children[ch - 'a'] == null)
                return false;
            
            node = node.children[ch - 'a'];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

