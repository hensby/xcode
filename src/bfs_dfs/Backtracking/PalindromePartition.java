package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//131
public class PalindromePartition {
    List<List<String>> res = new LinkedList<>();
    int len;
    String s;
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return res;
        this.s = s;
        this.len = s.length();
        helper(0, new LinkedList<>());
        return res;
    }

    public void helper(int index, LinkedList<String> tmpRes) {
        if(index >= len) {
            res.add(new LinkedList<>(tmpRes));
            return;
        }
        for(int i = index; i < len; i++) {
//            System.out.println(s.substring(index, index + i + 1));
            if(checkPalindrome(s.substring(index, i + 1))) {
                System.out.println(s.substring(index, i + 1));
                tmpRes.add(s.substring(index, i + 1));
                helper(i + 1, tmpRes);
                tmpRes.removeLast();
            }
        }
    }

    public boolean checkPalindrome(String tmp) {
        int left = 0, right = tmp.length() - 1;
        while(left < right) {
            if(tmp.charAt(left++) != tmp.charAt(right--)) return false;
        }
        return true;
    }


//    List<List<String>> res = new ArrayList<>();
//    String s;
//    int len;
    public List<List<String>> partition1(String s) {
        if (s.length() == 0) return res;
        this.s = s;
        this.len = s.length();
        dfs1(new ArrayList<>(), 0);
        return res;
    }

    public void dfs1(List<String> tmpRes, int start) {
        if (start > len) return;
        if (start == len) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        for (int i = start; i < len; i++) {
            if (isPalindrome(s.substring(start, i + 1))) {
                tmpRes.add(s.substring(start, i + 1));
                dfs1(tmpRes, i + 1);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition p = new PalindromePartition();
//        System.out.println(p.partition("aab"));
        System.out.println(p.partition1("aabacc"));
//      [[a, a, b, a, c, c], [a, a, b, a, cc], [a, aba, c, c], [a, aba, cc], [aa, b, a, c, c], [aa, b, a, cc]]
    }
}
