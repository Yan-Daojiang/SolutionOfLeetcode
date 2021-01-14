class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null)
            return null;

        int start = 0, end = nums.length - 1;
        while (start < end) {
            while ((start < end) && (nums[start] & (0x1)) == 1)
                ++start;
            while ((start < end) && (nums[end] & (0x1)) == 0)
                --end;
            if (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
            }
        }    
        return nums;
    }
}