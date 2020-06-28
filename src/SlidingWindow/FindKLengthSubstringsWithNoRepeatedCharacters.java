package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindKLengthSubstringsWithNoRepeatedCharacters {


    public int numKLenSubstrNoRepeats1(String S, int K) {
        if (S.length() < K) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        for (; j < K - 1; j++) {
            map.put(S.charAt(j), map.getOrDefault(S.charAt(j), 0) + 1);
        }
        for (; j < S.length(); j++,i++) {
            System.out.println(map);
            map.put(S.charAt(j), map.getOrDefault(S.charAt(j), 0) + 1);
            if (map.size() == K) res++;
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) - 1);
            if (map.get(S.charAt(i)) == 0) map.remove(S.charAt(i));
        }
        return res;
    }

    public int numKLenSubstrNoRepeats(String S, int K) {
        if(S.length() < K) return 0;
        int[] map = new int[26];
        int res = 0, len = S.length(), end = 0, countDup = 0;
        while(end < len) {
            if(map[S.charAt(end) - 'a']++ > 0) {
                countDup++;
            }
            if(end >= K && map[S.charAt(end-K)-'a']-- > 1) {
                countDup--;
            }
            if(countDup == 0 && end >= K - 1) {
                res++;
            }
            end++;
        }
        return res;
    }


    public static void main(String[] args) {
        String S = "havefunonleetcode";
        int K = 5;
        FindKLengthSubstringsWithNoRepeatedCharacters f = new FindKLengthSubstringsWithNoRepeatedCharacters();
        System.out.println(f.numKLenSubstrNoRepeats(S, K));
    }
}

//          LeetCode 1100. Find K-Length Substrings With No Repeated Characters
//
//        Given a string S, return the number of substrings of length K with no repeated characters.
//
//        Example 1:
//
//        Input: S = "havefunonleetcode", K = 5
//        Output: 6
//        Explanation:
//        There are 6 substrings they are : 'havef','avefu','vefun','efuno','etcod','tcode'.
//        Example 2:
//
//        Input: S = "home", K = 5
//        Output: 0
//        Explanation:
//        Notice K can be larger than the length of S. In this case is not possible to find any substring.
//        Note:
//
//        1 <= S.length <= 10^4
//        All characters of S are lowercase English letters.
//        1 <= K <= 10^4
