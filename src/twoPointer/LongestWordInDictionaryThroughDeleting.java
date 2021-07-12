package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public static String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private static boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(findLongestWord(s, dictionary));
    }
}
//524. Longest Word in Dictionary through Deleting
//        Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
//
//        Example 1:
//
//        Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//        Output: "apple"
//        Example 2:
//
//        Input: s = "abpcplea", dictionary = ["a","b","c"]
//        Output: "a"
//
//        Constraints:
//
//        1 <= s.length <= 1000
//        1 <= dictionary.length <= 1000
//        1 <= dictionary[i].length <= 1000
//        s and dictionary[i] consist of lowercase English letters.