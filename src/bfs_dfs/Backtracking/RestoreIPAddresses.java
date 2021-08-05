package bfs_dfs.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    List<String> res= new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) return res;
        StringBuilder sb = new StringBuilder();

        dfs(sb, s, 0);
        return res;
    }

    public void dfs(StringBuilder sb, String s, int flag) {
        System.out.println(sb + "   " + s + "   " + flag);
        if (s.length() == 0 && flag == 4) {
            res.add(sb.toString());
            return;
        }
        if (flag == 4) return;

        for (int i = 0; i < 3 && i < s.length(); i++) {
            if(s.charAt(0) == '0' && i > 0) {
                continue;
            }
            if (Integer.valueOf(s.substring(0, i + 1)) <= 255) {
                String tmpRes = s.substring(0, i + 1);
                if (flag != 0) {
                    tmpRes = '.' + tmpRes;
                }
                StringBuilder newSb = new StringBuilder(sb);
                newSb.append(tmpRes);
                dfs(newSb, s.substring(i + 1), flag + 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddresses remaining = new RestoreIPAddresses();
        System.out.println(remaining.restoreIpAddresses(s));
    }
}
//93. Restore IP Addresses
//        Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
//
//        A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//
//
//
//        Example 1:
//
//        Input: s = "25525511135"
//        Output: ["255.255.11.135","255.255.111.35"]
//        Example 2:
//
//        Input: s = "0000"
//        Output: ["0.0.0.0"]
//        Example 3:
//
//        Input: s = "1111"
//        Output: ["1.1.1.1"]
//        Example 4:
//
//        Input: s = "010010"
//        Output: ["0.10.0.10","0.100.1.0"]
//        Example 5:
//
//        Input: s = "101023"
//        Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
//
//
//        Constraints:
//
//        0 <= s.length <= 3000
//        s consists of digits only.