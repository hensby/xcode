package trackBack;

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

    public static void main(String[] args) {
        PalindromePartition p = new PalindromePartition();
        System.out.println(p.partition("aab"));
    }
}
