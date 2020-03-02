package DP;

import java.util.Arrays;

public class MinDistance {
    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (n > m) {
            return minDistance2(word2, word1);
        }
        int[] cur = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cur[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int pre = cur[0];
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = cur[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    cur[j] = pre;
                } else {
                    cur[j] = Math.min(pre, Math.min(cur[j], cur[j - 1])) + 1;
                }
                pre = temp;
            }
        }
        return cur[n];
    }

    public int minDistance(String S, String T) {
        int m = S.length(), n = T.length();
        int[][] a = new int[m + 1][n + 1];

        // a[i][j] represents substring of S of length i and substring of
        // T of length j
        // i.e. S.substring(0, i) and T.substring(0, j)
        for (int i = 0; i <= m; i++) {
            a[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            a[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // a[i][j] represents "S(i-1) + c1" and "T(j-1) + c2"
                // c1 = S.charAt(i-1) and c2 = T.charAt(j-1)
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    // no need to edit since c1 == c2
                    a[i][j] = a[i - 1][j - 1];
                } else {
                    // c1 != c2, we have three cases
                    // A: S(i-1) => T(j-1) and c1 => c2
                    // B: S(i) => T(j-1) and add c2
                    // C: S(i) delete c and then S(i-1) => T(j)
                    a[i][j] = 1 + Math.min(Math.min(a[i - 1][j - 1], a[i][j - 1]), a[i - 1][j]);
                }
                for (int[] h: a) {
                    System.out.println(Arrays.toString(h));
                }
                System.out.println();
            }
        }
        for (int[] i: a) {
            System.out.println(Arrays.toString(i));
        }
        return a[m][n];
    }

    public static void main(String[] args) {
        String s = "horse", t = "ros";
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance(s,t));
    }
}
//    Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
//        You have the following 3 operations permitted on a word:
//
//        Insert a character
//        Delete a character
//        Replace a character
//        Example 1:
//
//        Input: word1 = "horse", word2 = "ros"
//        Output: 3
//        Explanation:
//        horse -> rorse (replace 'h' with 'r')
//        rorse -> rose (remove 'r')
//        rose -> ros (remove 'e')
//
//        当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]；
//
//        当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
//
//        其中，dp[i-1][j-1] 表示替换操作，dp[i-1][j] 表示删除操作，dp[i][j-1] 表示插入操作。

