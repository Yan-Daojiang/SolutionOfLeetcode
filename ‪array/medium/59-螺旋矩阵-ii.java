/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (78.49%)
 * Likes:    318
 * Dislikes: 0
 * Total Accepted:    65.1K
 * Total Submissions: 83K
 * Testcase Example:  '3'
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int start = 0;
        int startNum = 1;
        while (2 * start < n) {
            int endX = n - 1 - start;
            int endY = n - 1 - start;

            for (int i = start; i <= endX; i++) {
                matrix[start][i] = startNum++; 
            }

            if (start < endY) {
                for (int i = start + 1; i <= endY; i++) {
                    matrix[i][endX] = startNum++;
                }
            }

            if (start < endX && start < endY) {
                for (int i = endY - 1; i >= start; i--) {
                    matrix[endY][i] = startNum++;
                }
            }

            if (start < endX && start < endY - 1) {
                for (int i = endX - 1; i >= start + 1; i--) {
                    matrix[i][start] = startNum++;
                }
            }

            ++start;
        }

        return matrix;
    }
}
// @lc code=end

