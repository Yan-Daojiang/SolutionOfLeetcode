class Solution {
    public int cuttingRope(int n) {
        if (n < 2)
            return 0;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] products = new int[n + 1];
        // ����ĵ�i��Ԫ�ر�ʾ����Ϊi�����˻�
        products[0] = 0; products[1] = 1; products[2] = 2; products[3] = 3;
        int max = 0;
        
        // �����ӵĳ��ȴ�����ʱ
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