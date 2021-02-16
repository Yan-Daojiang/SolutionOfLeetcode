import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return ans;

        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < len - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;

            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target)
                continue;

            for (int j = i + 1; j < len - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;

                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target)
                    continue;

                for (int k = j + 1; k < len - 1; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1])
                        continue;

                    if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target)
                        break;

                    if (nums[i] + nums[j] + nums[k] + nums[len - 1] < target)
                        continue;

                    // int right = len - 1;
                    for (int right = len - 1; right > k; right--) {
                        if (right != len - 1 && nums[right] == nums[right + 1])
                            continue;
                        if (nums[i] + nums[j] + nums[k] + nums[right] < target)
                            break;
                        if (nums[i] + nums[j] + nums[k] + nums[right] < target)
                            continue;

                        int sum = nums[i] + nums[j] + nums[k] + nums[right];

                        if (sum == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[right]);
                            ans.add(list);
                        }

                    } // for

                } // for

            } // for

        } // for

        return ans;
    }
}
// @lc code=end
