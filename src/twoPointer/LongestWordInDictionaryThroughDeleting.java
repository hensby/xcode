package twoPointer;

import java.util.*;

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

    public static String findLongestWord1(String s, List<String> dictionary) {
//        Collections.sort(dictionary, new Comparator<String>() {
//            public int compare(String word1, String word2) {
//                if (word1.length() != word2.length()) {
//                    return word2.length() - word1.length();
//                } else {
//                    return word1.compareTo(word2);
//                }
//            }
//        });
        Collections.sort(dictionary, (a, b) -> a.length() == b.length()? b.compareTo(a): a.length() > b.length()? -1: 1);

        for (String t : dictionary) {
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    ++i;
                }
                ++j;
            }
            if (i == t.length()) {
                return t;
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "pleass"));
        System.out.println(findLongestWord1(s, dictionary));
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