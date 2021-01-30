/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums== null || nums.length < k)
            return -1;

        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    /**
     * 若nums数组是递减排序的，则第k大的元素即为nums[k - 1]。
     * 对于无序序列nums[left..right]在其中查找第k大的元素，过程如下：
     * (1)若right >= left,即其中没有元素或者只有一个元素。
     * ---如果left == right且left == k - 1,则nums[k - 1]即为所求;
     * (2) 若 left > right,即其中有两个或者两个以上元素。采用快排的思想，
     * ----以为基准为中心划分，其中基准nums[i]归位，为第 i + 1大的元素，
     * ----nums[left.. i - 1]都大于nums[i],nums[i + 1..right]都小于a[i]。
     * ----此时又分如下三种情况：
     * ----(1.1) 若k - 1 == i,则nums[i]即为所求
     * ----(1.2) 若k - 1 > i,则在nums[i + 1, right]中递归查找
     * ----(1.3) 若k - 1 < i,则在nums[left, i -1]中递归查找 
     * @param nums
     * @param left
     * @param right
     * @param k
     * @return 无序序列nums[left..right]中第k大元素
     */
    private int quickSelect(int[] nums, int left, int right, int k) {
        int i = left, j = right;
        int tmp;
        if (left < right) {
            tmp = nums[left];
            while (i < j) {
                while (i < j && nums[j] <= tmp)
                    j--;
                nums[i] = nums[j];

                while (i < j && nums[i] >= tmp)
                    i++;
                nums[j] = nums[i];
            }
            nums[i] = tmp;

            if (k - 1 == i)
                return nums[i];
            else if (k - 1 > i)
                return quickSelect(nums, i + 1, right, k);
            else 
                return quickSelect(nums, left, i - 1, k);
        }
        else if (left == right && left == k - 1)
            return nums[k - 1];
        return -1;
    }
}
// @lc code=end

