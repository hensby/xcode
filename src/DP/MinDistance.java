package DP;

import java.util.Arrays;

public class MinDistance {
    public int minDistance1(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] count = new int[m + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            count[0][i] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            count[j][0] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] = 1 + Math.min(Math.min(count[i - 1][j - 1], count[i][j - 1]),count[i - 1][j]);
                }
            }
        }
        return count[m][n];
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
                    a[i][j] = 1 + Math
                            .min(Math.min(a[i - 1][j - 1], a[i][j - 1]),
                                    a[i - 1][j]);
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
