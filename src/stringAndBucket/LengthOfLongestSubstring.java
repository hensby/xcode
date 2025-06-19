package stringAndBucket;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.cn/problems/longest-substring-without-repeating-characters/
//3. Longest Substring Without Repeating Characters
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left,map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right),right);
            max = Math.max(max,right-left+1);
            right ++;
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length(), left = 0, right = 0, res = 0;
        Set<Character> charSet = new HashSet<>();
        while(right < len) {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }




    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String input = "abcabcbb";
        System.out.println(l.lengthOfLongestSubstring1(input));
    }
}

//https://neetcode.io/problems/longest-substring-without-duplicates?list=neetcode150
//Longest Substring Without Repeating Characters
//Solved
//Given a string s, find the length of the longest substring without duplicate characters.
//
//A substring is a contiguous sequence of characters within a string.
//
//Example 1:
//
//Input: s = "zxyzxyz"
//
//Output: 3
//Explanation: The string "xyz" is the longest without duplicate characters.
//
//Example 2:
//
//Input: s = "xxxx"
//
//Output: 1
//Constraints:
//
//0 <= s.length <= 1000
//s may consist of printable ASCII characters.