class Solution {
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] products = new int[n + 1];
        // 数组的第i个元素表示长度为i的最大乘积
        products[0] = 0; products[1] = 1; products[2] = 2; products[3] = 3;
        int max = 0;
        
        // 当绳子的长度大于三时
        for (int i = 4; i <= n; ++i) {
            max = 0;
            for (int j = 1; j <= i / 2; ++j) {
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;

                products[i] = max;
            } // for
        } // for
        
        max = products[n];
        return max;
    }
}