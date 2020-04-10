package DP;

import java.util.Arrays;
//lc 1000
public class MergeStone {
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if((n-1)%(K-1) != 0){
            return -1;
        }

        int [] preSum = new int[n+1];
        for(int i = 1; i<=n; i++){
            preSum[i] = preSum[i-1] + stones[i-1];
        }
        System.out.println(Arrays.toString(preSum));

        int [][] dp = new int[n][n];
        for(int size = 2; size<=n; size++){
            for(int i = 0; i<=n-size; i++){
                int j = i+size-1;
                dp[i][j] = Integer.MAX_VALUE;

                for(int m = i; m<j; m += K-1){
                    dp[i][j] = Math.min(dp[i][j], dp[i][m]+dp[m+1][j]);
                }

                if((size-1) % (K-1) == 0){
                    dp[i][j] += preSum[j+1] - preSum[i];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] stones = new int[]{3,5,1,2,6};
        int K = 3;
        MergeStone mergeStone = new MergeStone();
        System.out.println(mergeStone.mergeStones(stones, K));
    }
}
