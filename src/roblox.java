import java.util.Arrays;
import java.util.List;

public class roblox {
        public static void main(String[] args) {
            int[] arrival = {1,3,5};
            int[] duration = {2,2,2};
            System.out.println(maxEvents(arrival, duration));
        }
        public static int maxEvents(int[] arrivals, int[] departures){
            int[][] events = new int[arrivals.length][2];
            for(int i=0; i<arrivals.length;i++){
                events[i][0] = arrivals[i];
                events[i][1] = arrivals[i]+departures[i];
            }

            Arrays.sort(events, (a, b) -> (a[0]-b[0]));

            int totalEvents = 0;
            int currentEventEndTime = events[0][1];

            for(int i=1;i<events.length-1;i++){
                if(currentEventEndTime <= events[i+1][0]){
                    currentEventEndTime = events[i+1][1];
                    totalEvents++;
                }
            }
            return totalEvents+1;
        }



    public static int largestSubgrid(List<List<Integer>> grid, int maxSum) {
        // Write your code here
        int n=grid.size();int m=grid.get(0).size();
        int [][] dp=new int [n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = grid.get(i - 1).get(j - 1) + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }
        int ans=0;
        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                for(int k=ans;i+k<=n&&j+k<=m;)
                {
                    int temp=dp[i+k][j+k]-dp[i-1][j+k]-dp[i+k][j-1]+dp[i-1][j-1];
                    if(temp<=maxSum) {
                        ans++;
                        k++;
                    }
                    else break;
                }
            }
        }
        return ans;
    }
}

