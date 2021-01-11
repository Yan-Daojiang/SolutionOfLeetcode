/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid == null)
            return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (dfs(grid, i, j) >= 1)
                    ++count;
        return count;
    }
    
    private int dfs(char[][] grid, int i, int j) {
        // 从位置（i， j）进行搜索，如果搜索到一个岛屿就返回true, 否则返回false
        if (i < 0 || i > grid.length - 1 || j < 0|| j > grid[0].length - 1 || grid[i][j] == '0')
            return 0;

        // 当前开始能够搜索到一个岛屿
        grid[i][j] = '0'; // 标记为水，避免重复计数
        return 1 + dfs(grid, i, j + 1) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i - 1, j);
    }
}
// @lc code=end

