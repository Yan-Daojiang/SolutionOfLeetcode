import java.util.List;

/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (45.55%)
 * Likes:    642
 * Dislikes: 0
 * Total Accepted:    258.3K
 * Total Submissions: 566K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：digits = [0]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();

        int flag = 0;
        for (int i = digits.length - 1; i>= 0; i--) {
            int curNumber = 0;
            if (i == digits.length - 1) {
                curNumber = (digits[i] + flag + 1) % 10;
                flag = (digits[i] + flag + 1) / 10;
            } else {
                curNumber = (digits[i] + flag) % 10;
                flag = (digits[i] + flag) / 10;
            }
            list.add(curNumber);
        }

        if (flag == 1) {
            list.add(1);
        }

        int size = list.size();

        int[] ans = new int[size];
        int index = size - 1;

        for (Integer num : list) {
            ans[index] = num;
            --index;
        }

        return ans;
    }
}
// @lc code=end

