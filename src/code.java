import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//news string common word 50
//
//input 2 string
//output list[string]
//
//string[]
//new new string is is aaaaaaaaaa
//new string is a
//
//string[]
//map<> string int
//map<> string int
//keyset
public class code {
    public String[] getCommonWords(String[] s1, String[] s2) {
        if(s1.length == 0 || s2.length == 0) return new String[0];
        Map<String, Integer> map1 = new HashMap<>();
        for(String s: s1) {
            map1.put(s,map1.getOrDefault(s,0) + 1);
        }
        Map<String, Integer> map2 = new HashMap<>();
        for(String s: s2) {
            if(!map1.containsKey(s)) continue;
            if(map1.containsKey(s) && map2.containsKey(s) && map1.get(s) <= map2.get(s)) {
                continue;
            }
            map2.put(s,map2.getOrDefault(s,0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((l1, l2) -> map2.get(l1) - map2.get(l2));
        for(String s: map2.keySet()) {
            pq.add(s);
        }
        String[] res = new String[50];
        for(int i = 0; i < 50; i++) {
            res[i] = pq.poll();
        }
        return res;
    }


//2 String S 编辑距离
//sunaday sunday delete insert replace
//
//dp[]
//        s u n d a y
//     0  1 2 3 4 5 6
//
//        s u n d a y
//s       0 1 2 3 4 5
//u       1 0
//n       2   0
//a       3
//a       4
//y       5

    public int editDixtance(String s1, String s2) {
        if(s1.length() == 0) return s2.length();
        if(s2.length() == 0) return s2.length();
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0; i <= len1; i++) dp[i][0] = i;
        for(int j = 0; j <= len2; j++) dp[0][j] = j;
        for(int i = 1; i < len1 + 1; i++) {
            for(int j = 1; j < len2 + 1; j++) {
                if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[len1][len2];
    }
}