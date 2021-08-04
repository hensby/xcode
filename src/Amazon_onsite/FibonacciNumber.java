package Amazon_onsite;

import binaryTree.main;

public class FibonacciNumber {

    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            System.out.println(p + " " + q + " " + r);

            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static int fiNum(int n) {
        if (n < 2) return n;
        if (n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            System.out.println(a + " " + b + " " + c);
            a = b;
            b = c;
            c = a + b;

        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fiNum(10));

    }

}
//509. Fibonacci Number
//        The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//        F(0) = 0, F(1) = 1
//        F(n) = F(n - 1) + F(n - 2), for n > 1.
//        Given n, calculate F(n).
//
//
//
//        Example 1:
//
//        Input: n = 2
//        Output: 1
//        Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//        Example 2:
//
//        Input: n = 3
//        Output: 2
//        Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//        Example 3:
//
//        Input: n = 4
//        Output: 3
//        Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
