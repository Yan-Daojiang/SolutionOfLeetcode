/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder ans = new StringBuilder();
        
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];
        int[] target = new int[num1.length() + num2.length()];

        convertToArray(arr1, num1);
        convertToArray(arr2, num2);

        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int k = i + j;
                target[k] += arr1[i] * arr2[j];

                while (target[k] > 9) {
                    target[k + 1] += target[k] / 10;
                    target[k] %= 10;
                    k++;
                }
            }
        }

        int high = num1.length() + num2.length() - 1;
        while (target[high] == 0 && high > 0)
            high--;

        for (int i = high; i >= 0; --i) {
            ans.append((char)(target[i] + '0'));
        }

        return ans.toString();
    }

    private void convertToArray(int[] arr, String num) {
        // "123"===> [3, 2, 1]
        int len = num.length();
        for (int i = 0; i < num.length(); i++) 
            arr[i] = num.charAt(len - 1 - i) - '0';
    }
}
// @lc code=end

