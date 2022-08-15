package twoPointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfString {

    static Set<Character> vowelsSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] result = new char[s.length()];
        while(left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!vowelsSet.contains(leftChar)) result[left++] = leftChar;
            else if (!vowelsSet.contains(rightChar)) result[right--] = rightChar;
            else {
                result[left++] = rightChar;
                result[right--] = leftChar;
            }
        }
        return new String(result);
    }

    public static String reverseVowels1(String s) {
        int length = s.length();
        if (length <= 1) return s;
        int left = 0, right = length - 1;
        char[] result = new char[length];
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        while (left <= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!vowels.contains(leftChar)) {
                result[left] = leftChar;
                left++;
            } else if (!vowels.contains(rightChar)) {
                result[right] = rightChar;
                right--;
            } else {
                result[left] = rightChar;
                result[right] = leftChar;
                left++;
                right--;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels1("leetcode"));

    }
}
