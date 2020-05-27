package DP;

import java.util.Arrays;

public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                System.out.println(Arrays.deepToString(f));
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }
        return f[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence longestPalindromeSubsequence = new LongestPalindromeSubsequence();
        String input = "bbbab";
        System.out.println(longestPalindromeSubsequence.longestPalindromeSubseq(input));
    }
}
