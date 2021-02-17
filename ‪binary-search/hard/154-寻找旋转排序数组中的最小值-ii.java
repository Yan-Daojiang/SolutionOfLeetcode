/*
 * @lc app=leetcode.cn id=154 lang=java
 *
 * [154] 寻找旋转排序数组中的最小值 II
 */

// @lc code=start
class Solution {
    public int findMin(int[] numbers) {
        int index1 = 0, index2 = numbers.length - 1;
        int midIndex = index1;
        while (numbers[index1] >= numbers[index2]) {
            if (index2 - index1 == 1) {
                midIndex = index2;
                break;
            }

            midIndex = (index1 + index2) / 2;

            if (numbers[index1] == numbers[index2] && numbers[index1] == numbers[midIndex])
                return minInOrder(numbers, index1, index2);
            
            if (numbers[midIndex] >=  numbers[index1])
                index1 = midIndex;
            else if (numbers[midIndex] <= numbers[index2])
                index2 = midIndex;
        } // while
        return numbers[midIndex];
    }

    private int minInOrder(int[] numbers, int index1, int index2) {
        int ans = numbers[index1];
        for (int i = index1 + 1; i <= index2; ++i) 
            if (ans > numbers[i])
                ans = numbers[i];
        
        return ans;
    }
}
// @lc code=end

