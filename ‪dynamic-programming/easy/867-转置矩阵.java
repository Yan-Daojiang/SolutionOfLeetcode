/*
 * @lc app=leetcode.cn id=867 lang=java
 *
 * [867] 转置矩阵
 */

// @lc code=start
class Solution {
    public int[][] transpose(int[][] A) {
        int[][] ans = new int[A[0].length][A.length];
        for(int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                ans[j][i] = A[i][j];
        return ans;
    }
}
// @lc code=end

