package DP;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        //计算数组的和sum，如果sum为奇数，那肯定不能分成两部分，直接返回false
        for(int i = 0; i<nums.length; i++) sum += nums[i];
        if(sum % 2 != 0) return false;
        sum = sum/2;
        //初始化base case :dp[...][0] = true，相当于当载重量为0的时候，肯定什么东西也不用放，背包肯定默认是满的，因为载重量为0嘛，所以是true；dp[0][...] = false,相当于在任一载重量时，什么东西都不放，那肯定背包没有满，所以是false
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int i = 0; i<nums.length+1; i++) dp[i][0] = true;
        //这里可以省略，因为java中boolean量默认是false，这里没有注释掉是因为想把逻辑表达清楚。
        for(int i = 0; i<sum+1; i++) dp[0][i] = false;


        for(int i = 1; i<=nums.length; i++){
            for(int j = 1; j<=sum; j++){
                //如果当前的背包容量比要放的数量都小，那就没法放，只能继承之前的状态
                if(j < nums[i-1]) dp[i][j] = dp[i-1][j];
                else{
                    //放入或者不放入，不管哪种状态，只要能放满就可以
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        int[] input = new int[] {1, 5, 11, 5};
        System.out.println(partitionEqualSubsetSum.canPartition(input));
    }
}
