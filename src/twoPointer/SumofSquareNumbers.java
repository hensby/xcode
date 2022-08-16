package twoPointer;

public class SumofSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int tmpSum = left * left + right * right;
            if (tmpSum == c) return true;
            else if (tmpSum > c) {
                right--;
            } else left++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(10));
        System.out.println(judgeSquareSum(5));
    }
}
