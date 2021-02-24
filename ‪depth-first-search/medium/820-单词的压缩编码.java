import java.util.Arrays;
import java.util.Comparator;
/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        int ans = 0;
        
        class Trie {
            TrieNode root;
            
            
            class TrieNode {
                public TrieNode[] children;

                public TrieNode() {
                    children = new TrieNode[26];
                }
            }

            public Trie () {
                root = new TrieNode();
            }

            // 按照单词中字符倒序进行插入
            public int insert(String word) {
                if (word == null || word.length() == 0)
                    return 0;
                
                int len = word.length();
                TrieNode node = root;
                boolean isNew = false;

                for (int i = len - 1; i >= 0; i--) {
                    char currChar = word.charAt(i);
                    if (node.children[currChar - 'a'] == null) {
                        node.children[currChar - 'a'] = new TrieNode();
                        isNew = true;
                    }
                    node = node.children[currChar - 'a'];
                }
                
                return (isNew == true ? len + 1 : 0); 
            }
        }


        if (words == null || words.length == 0)
            return ans;

        // 对words按照单词由长到短进行排序
        Arrays.sort(words, (word1, word2)->word2.length() - word1.length());

        Trie trie = new Trie();
        
        for (String word : words) {
            ans += trie.insert(word);
        }

        return ans;
    }
}
// @lc code=end

