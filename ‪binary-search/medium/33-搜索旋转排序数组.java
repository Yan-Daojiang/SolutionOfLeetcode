import java.lang.annotation.Target;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;

        return binarySearch(nums, 0, len - 1, target);
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        if (right < left)
            return -1;
        
        int mid = (left + right) / 2;

        int leftValue = nums[left];
        int rightValue = nums[right];
        int midValue = nums[mid];

        if (leftValue == target)
            return left;
        else if (rightValue == target)
            return right;
        else if (midValue == target)
            return mid;

        if (leftValue < midValue) {
            if (target < midValue && target > leftValue) {
                return binarySearch(nums, left + 1, mid - 1, target);
            } else {
                return binarySearch(nums, mid + 1, right - 1, target);
            }
        } else {
            if (target > midValue && target < rightValue) {
                return binarySearch(nums, mid + 1, right - 1, target);
            } else {
                return binarySearch(nums, left + 1, mid - 1, target);
            }
        }
    }

}
// @lc code=end

// class Solution {
//     public int search(int[] nums, int target) {
//         if (nums == null || nums.length == 0)
//             return -1;

//         if (nums.length == 1) {
//             if (target == nums[0])
//                 return 0;

//             return -1;
//         }

//         int len = nums.length;
//         // 找到旋转的位置，具体做法见153题
//         int index = findIndex(nums);
//         int ans = -1;

//         if (index == 0) {
//             ans = Arrays.binarySearch(nums, target);  
//         } else if (nums[0] > target) {
//             ans = Arrays.binarySearch(nums, index, len, target);
//         } else {
//            ans = Arrays.binarySearch(nums, 0, index, target);
//         }

//         if (ans < 0)
//             return -1;
        
//         return ans;
//     }

//     public int findIndex(int[] nums) {
//         if (nums == null ||nums.length == 0)
//             return -1;

//         int low = 0, high = nums.length - 1;
//         if (nums[low] < nums[high]) // 没有旋转
//             return low;

//         while (low <= high) {
//             int mid = (low + high) / 2;

//             if (nums[mid] > nums[mid + 1])
//                 return mid + 1;
            
//             if (nums[mid] < nums[mid - 1])
//                 return mid;
            
//             if (nums[mid] > nums[0]) 
//                 low = mid + 1;
//             else if (nums[mid] < nums[0])
//                 high = mid - 1;
//         }

//         return -1;
//     }
// }