package Amazon_onsite;

public class Pow {

    public static double myPow(double x, int n) {
        if (n == 0) return 1;
        return n > 0 ? powHelper(x, n) : 1 / powHelper(x, -n);
    }

    public static double powHelper(double x, int n) {
        if (n == 0) return 1;
        double tmpPow = powHelper(x, n / 2);
        return n % 2 == 0 ? tmpPow * tmpPow : tmpPow * tmpPow * x;
    }

    public static double myPow1(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x, n));
        System.out.println(myPow1(x, n));
    }
}
