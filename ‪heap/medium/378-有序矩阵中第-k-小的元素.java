import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=378 lang=java
 *
 * [378] 有序矩阵中第 K 小的元素
 *
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
 *
 * algorithms
 * Medium (63.29%)
 * Likes:    570
 * Dislikes: 0
 * Total Accepted:    66.6K
 * Total Submissions: 105.1K
 * Testcase Example:  '[[1,5,9],[10,11,13],[12,13,15]]\n8'
 *
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == matrix.length
 * n == matrix[i].length
 * 1 
 * -10^9 
 * 题目数据 保证 matrix 中的所有行和列都按 非递减顺序 排列
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0 ; i < row; i++) {
            for (int j = 0; j < col; j++) {
                heap.offer(matrix[i][j]);
            }
        }

        for (int i = 1 ; i < k; i++) {
            heap.poll();
        }

        return heap.peek();
    }
}
// @lc code=end

