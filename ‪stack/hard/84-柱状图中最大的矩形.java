import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 *
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/description/
 *
 * algorithms
 * Hard (42.74%)
 * Likes:    1250
 * Dislikes: 0
 * Total Accepted:    132.5K
 * Total Submissions: 308.7K
 * Testcase Example:  '[2,1,5,6,2,3]'
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 
 * 
 * 
 * 
 * 
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * 
 * 
 * 
 * 
 * 
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * 
 */

// @lc code=start
class Solution {
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

// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int largetArea = 0;
//         int len = heights.length;

//         for (int index = 0; index < len; index++) {
//             int height = heights[index];

//             int i = index;
//             while (i >= 0 && heights[i] >= height) {
//                 --i;
//             }

//             int j = index;
//             while (j < len && heights[j] >= height) {
//                 ++j;
//             }

//             int width = j - i - 1;
//             // System.out.println(width);
//             largetArea = Math.max(largetArea, height * width);
//         }

//         return largetArea;
//     }
// }

