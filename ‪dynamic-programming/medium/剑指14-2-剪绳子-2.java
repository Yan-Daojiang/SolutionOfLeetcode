class Solution {
    public int cuttingRope(int n) {
        // ̰���㷨���
        if (n <= 3)
            return n - 1;
        if (n == 4)
            return n;
        long ans = 1;
        while (n > 4) {
            ans *= 3;
            ans %= (1e9 + 7);
            n -= 3;
        }
        
        // ���n��ֵֻ�п����ǣ�2��3��4����2��3��4�ܵõ������˻�ǡǡ��������ֵ
        return (int)(ans * n % (1e9 + 7));
    }
}