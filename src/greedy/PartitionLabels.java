package greedy;

import java.util.*;

// 763
public class PartitionLabels {
    public static List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return null;
        int len = s.length();
        int[] indexTable = new int[26];
        for (int i = 0; i < len; i++) {
            indexTable[s.charAt(i) - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0;
        while (start < len) {
            char startLetter = s.charAt(start);
            int endindex = indexTable[startLetter - 'a'];
            for (int i = 0; i < endindex; i++) {
//                System.out.println(endindex);
                endindex = indexTable[s.charAt(i) - 'a'] > endindex ? indexTable[s.charAt(i) - 'a'] : endindex;
            }
            res.add(endindex - start + 1);
            start = endindex + 1;
        }
        return res;
    }

    public static List<Integer> partitionLabels1(String S) {
        if (null == S || 0 == S.length()) {
            return null;
        }
        int len = S.length();

        // index table
        int[] indexTable = new int[26];
        for (int i = 0; i < len; ++i) {
            indexTable[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int left = 0;
        while (left < len) {
            char curLeft = S.charAt(left);
            // 最小右边界
            int right = indexTable[curLeft - 'a'];
            for (int i = left + 1; i < right; ++i) {
                // 枚举当前分段中的字符，更新右边界
                if (indexTable[S.charAt(i) - 'a'] > right) {
                    right = indexTable[S.charAt(i) - 'a'];
                }
            }
            // 至此，一个新的片段生成了
            ans.add(right - left + 1);
            // 分析下一段
            left = right + 1;
        }
        return ans;
    }

    public static List<Integer> partitionLabels2(String s) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        Map<Character, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            positionMap.put(c, i);
        }
        int len = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, positionMap.get(s.charAt(i)));
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels2(s);
        System.out.println(s.substring(0, res.get(0)));
        for (int i = 1; i < res.size(); i++) {
            System.out.println(s.substring(res.get(i - 1), res.get(i - 1) + res.get(i)));
        }

    }

}
//763. Partition Labels
//        You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
//
//        Return a list of integers representing the size of these parts.
//
//
//
//        Example 1:
//
//        Input: s = "ababcbacadefegdehijhklij"
//        Output: [9,7,8]
//        Explanation:
//        The partition is "ababcbaca", "defegde", "hijhklij".
//        This is a partition so that each letter appears in at most one part.
//        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//        Example 2:
//
//        Input: s = "eccbbbbdec"
//        Output: [10]
//
//
//        Constraints:
//
//        1 <= s.length <= 500
//        s consists of lowercase English letters.