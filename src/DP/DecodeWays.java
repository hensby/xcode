package DP;

import java.util.Arrays;

public class DecodeWays {
    // 1 2   --> 2
    // 1 2 0 --> 1
    // 1 2 0 1 --> 1
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = arr[0]=='0'?0:1;
        if(s.length()<=1) return dp[1];
        for(int i=2;i<=s.length();i++){
            int n = (arr[i-2]-'0')*10+(arr[i-1]-'0');
            if(arr[i-1]=='0' && arr[i-2]=='0'){
                return 0;
            }else if(arr[i-2]=='0'){
                dp[i] = dp[i-1];
            }else if(arr[i-1]=='0'){
                if(n>26) return 0;
                dp[i] = dp[i-2];
            }else if(n>26){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("1239209"));
    }

}
//          定义dp[i]是nums前i个字符可以得到的解码种数，假设之前的字符串是abcx，现在新加入了y，则有以下5种情况：
//
//        如果x=='0'，且y=='0'，无法解码，返回0；
//        如果只有x=='0'，则y只能单独放在最后，不能与x合并(不能以0开头)，此时有：
//        dp[i] = dp[i-1]
//        如果只有y=='0'，则y不能单独放置，必须与x合并，并且如果合并结果大于26，返回0，否则有：
//        dp[i] = dp[i-2]
//        如果 xy<=26: 则y可以“单独”放在abcx的每个解码结果之后后，并且如果abcx以x单独结尾，此时可以合并xy作为结尾，而这种解码种数就是abc的解码结果，此时有：
//        dp[i+1] = dp[i] + dp[i-1]
//        如果 xy>26: 此时x又不能与y合并，y只能单独放在dp[i]的每一种情况的最后，此时有：
//        dp[i+1] = dp[i]

