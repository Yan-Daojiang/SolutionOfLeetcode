/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (51.63%)
 * Likes:    867
 * Dislikes: 0
 * Total Accepted:    74K
 * Total Submissions: 143.4K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：matrix =
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：matrix = []
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：matrix = [["0"]]
 * 输出：0
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：matrix = [["1"]]
 * 输出：1
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：matrix = [["0","0"]]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * rows == matrix.length
 * cols == matrix[0].length
 * 0 
 * matrix[i][j] 为 '0' 或 '1'
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int[] heights = new int[matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            max = Math.max(max, largestRectangleArea(heights));
        }

        return max;

    }

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return heights[0];
        }



        int[] newHeigths = new int[len + 2];

        for (int i = 0; i < heights.length; i++) {
            newHeigths[i + 1] = heights[i];
        }

        heights = newHeigths;

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int area = 0;

        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peek()]) {
                // 当前遍历到的严格小于栈顶的 
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;


                area = Math.max(area, width * height);
            }

            stack.push(i);
        }

        return area;
    }
}
// @lc code=end

