package binarySearch;

public class Sqrt {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid);
            int tmpSqrt = x / mid;
            if (tmpSqrt == mid) {
                return mid;
            } else if (tmpSqrt > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int mySqrt2(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x / mid == mid) {
                return mid;
            } else if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int mySqrt1(int x) {
        if (x <= 1) return x;
        int left = 1;
        int right = x - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1; // only for return a value
    }

    public static void main(String[] args) {
        System.out.println(mySqrt2(2147395599));
        System.out.println(mySqrt1(2147395599));
    }
}
//69. Sqrt(x)
//        Given a non-negative integer x, compute and return the square root of x.
//
//        Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
//
//        Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
//
//
//
//        Example 1:
//
//        Input: x = 4
//        Output: 2
//        Example 2:
//
//        Input: x = 8
//        Output: 2
//        Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
//
//
//        Constraints:
//
//        0 <= x <= 231 - 1