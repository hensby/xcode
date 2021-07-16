package gragh.Backtracking;

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
                return;
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
