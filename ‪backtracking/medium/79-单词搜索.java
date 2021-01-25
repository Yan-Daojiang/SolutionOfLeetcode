/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0)
            return false;

        boolean used[][] = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (dfs(board, i, j, used, word, 0))
                    return true;

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, boolean[][] used, String word, int matchLength) {
        if (matchLength == word.length())
            return true;

        boolean exist = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && used[i][j] == false && board[i][j] == word.charAt(matchLength)) {
            ++matchLength;
            used[i][j] = true;
            exist = dfs(board, i + 1, j, used, word, matchLength) || dfs(board, i - 1, j, used, word, matchLength) || dfs(board, i, j + 1, used, word, matchLength) || dfs(board, i, j - 1, used, word, matchLength);

            if (!exist) {
                --matchLength;
                used[i][j] = false;
            }
        }

        return exist;
    }
}
// @lc code=end

