package twoPointer;

public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome1(String s) {
        int length = s.length();
        if (length == 0) return false;
        int left = 0, right = length - 1;
        while(left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome1(s.substring(left + 1, right + 1)) || isPalindrome1(s.substring(left, right));
            }
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindrome(s));
    }
}

// abfghhgfdba   => fghhgf or ghhgfd

//680. Valid Palindrome II
//        Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//
//
//
//        Example 1:
//
//        Input: s = "aba"
//        Output: true
//        Example 2:
//
//        Input: s = "abca"
//        Output: true
//        Explanation: You could delete the character 'c'.
//        Example 3:
//
//        Input: s = "abc"
//        Output: false
//
//
//        Constraints:
//
//        1 <= s.length <= 105
//        s consists of lowercase English letters.