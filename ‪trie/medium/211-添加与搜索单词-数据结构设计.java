import jdk.internal.icu.util.CodePointTrie.Fast;

/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {
    class TrieNode {
        public TrieNode[] children;
        public boolean isEnd = false;
    
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    } 

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        if (word == null || word.length() == 0)
            return ;
        
        TrieNode node = root;

        char[] chs = word.toCharArray();
        for (char ch : chs) {
            if (node.children[ch - 'a'] == null)
                node.children[ch - 'a'] = new TrieNode();
            
            node = node.children[ch - 'a'];
        }
        
        node.isEnd = true;
    }
     
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, TrieNode node, int start) {
        if (start == word.length())
            return node.isEnd;

        char ch = word.charAt(start);
        if (ch != '.') {
            if (node.children[ch - 'a'] == null)
                return false;

            return dfs(word, node.children[ch - 'a'], start + 1);
        } else {
            int index = 0;
            for (index = 0; index < 26; index++) {
                // 递归遍历node节点后面的所有路径
                if (node.children[index] != null && dfs(word, node.children[index], start + 1))
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

