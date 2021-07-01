package DP;

import java.util.Arrays;

public class LongestPalindromeSubString {
    public String longestPalindrome2(String s) {
        if (s.equals("")) return "";
        int length = s.length();
        String reverse = new StringBuilder(s).reverse().toString();
        int maxLen = 0,maxEnd = 0;
        int[][] count = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) count[i][j] = 1;
                    else count[i][j] = count[i - 1][j - 1] + 1;
                }
                if (count[i][j] > maxLen) {
                    if (i == length - 1 - j + count[i][j] - 1) {
                        maxLen = count[i][j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }


    public String longestPalindrome(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuilder(s).reverse().toString();
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                /**********修改的地方*******************/
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }
                    /*************************************/
                }
            }
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public String longestPalindrome1(String s) {
        if (s.equals(""))
            return "";
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++)
        /**************修改的地方***************************/
            for (int j = length - 1; j >= 0; j--) {
                /**************************************************/
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                    /**************修改的地方***************************/
                    //之前二维数组，每次用的是不同的列，所以不用置 0 。
                } else {
                    arr[j] = 0;
                }
                /**************************************************/
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[j] - 1 == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }

                }
            }
        System.out.println(Arrays.toString(arr));
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    public static void main(String[] args) {
        String s = "abac";
        LongestPalindromeSubString longestPalindrome = new LongestPalindromeSubString();
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
//5. Longest Palindromic Substring
//        Given a string s, return the longest palindromic substring in s.
//
//        Example 1:
//
//        Input: s = "babad"
//        Output: "bab"
//        Note: "aba" is also a valid answer.
//        Example 2:
//
//        Input: s = "cbbd"
//        Output: "bb"
//        Example 3:
//
//        Input: s = "a"
//        Output: "a"
//        Example 4:
//
//        Input: s = "ac"
//        Output: "a"
//
//
//        Constraints:
//
//        1 <= s.length <= 1000
//        s consist of only digits and English letters (lower-case and/or upper-case),
