package DP;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
//        System.out.println(Arrays.toString(dp));
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    System.out.println(s.substring(j, i));
                    dp[i] = true;
                    System.out.println(Arrays.toString(dp));
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        // boolean[] dp = new boolean[s.length() + 1];
        // dp[0] = true;
        // for (int i = 1; i <= s.length(); i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
        //             dp[i] = true;
        //             break;
        //         }
        //     }
        // }
        // return dp[s.length()];
        System.out.println(wordDictSet);
        int i = 0;
        int j = 1;
        System.out.println(i + "   " + j + "  " + s.length());
        while(i <= j && j <= s.length()) {

            if (wordDictSet.contains(s.substring(i, j))) {
                System.out.println(s.substring(i, j));
                i = j;
            }
            if (i== j && j == s.length()) return true;
            System.out.println(i + "   " + j);
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>() ;
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak.wordBreak1(s,wordDict));
    }

}
