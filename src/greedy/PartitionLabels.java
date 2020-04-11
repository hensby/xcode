package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 763
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
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
                endindex = indexTable[s.charAt(i) - 'a'] > endindex ? indexTable[s.charAt(i) - 'a']:endindex;
            }
            res.add(endindex - start + 1);
            start = endindex + 1;
        }
        return res;
    }

    public List<Integer> partitionLabels1(String S) {
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


    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        List<Integer> res = partitionLabels.partitionLabels(s);
        System.out.println(s.substring(0, res.get(0)));
        for (int i= 1; i < res.size(); i++) {
            System.out.println(s.substring(res.get(i - 1), res.get(i - 1) + res.get(i)));
        }

    }

}
