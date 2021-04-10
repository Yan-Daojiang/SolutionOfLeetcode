import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=407 lang=java
 *
 * [407] 接雨水 II
 *
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 *
 * algorithms
 * Hard (46.98%)
 * Likes:    325
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 16.3K
 * Testcase Example:  '[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]'
 *
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * 
 * 
 * 
 * 示例：
 * 
 * 给出如下 3x6 的高度图:
 * [
 * ⁠ [1,4,3,1,3,2],
 * ⁠ [3,2,1,3,2,4],
 * ⁠ [2,3,3,2,3,1]
 * ]
 * 
 * 返回 4 。
 * 
 * 
 * 
 * 
 * 如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。
 * 
 * 
 * 
 * 
 * 
 * 下雨后，雨水将会被存储在这些方块中。总的接雨水量是4。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= m, n <= 110
 * 0 <= heightMap[i][j] <= 20000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length;
        int col = heightMap[0].length;

        if (heightMap == null || row <= 1 || col <= 1)
            return 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (o1, o2)->(o1[2]- o2[2])
        );

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    heap.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        int[] directions = {-1, 0, 1, 0, -1};
        
        while (!heap.isEmpty()) {
            int[] cur = heap.poll(); // 当前考虑的柱子的坐标和高度
            
            for (int k = 0; k < 4; k++) {
                int x = cur[0] + directions[k];
                int y = cur[1] + directions[k + 1];

                if (x >= 0 && x < row && y >= 0 && y < col && !visited[x][y]) {
                    if (cur[2] > heightMap[x][y]) {
                        ans += cur[2] - heightMap[x][y];
                    }
    
                    visited[x][y] = true;
                    heap.offer(new int[]{x, y, Math.max(heightMap[x][y], cur[2])});
                }
            }
        }

        return ans;
    }
}
// @lc code=end

