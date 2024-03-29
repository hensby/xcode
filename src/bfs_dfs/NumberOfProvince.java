package bfs_dfs;

public class NumberOfProvince {
    int[][] isConnected;
    int len;
    boolean[] isVisit;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) return 0;
        if (isConnected.length == 1) return 1;
        this.isConnected = isConnected;
        this.len = isConnected.length;
        this.isVisit = new boolean[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                dfs(i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int city) {
        for (int i = 0; i < len; i++) {
            if (!isVisit[i] && isConnected[city][i] == 1) {
                isVisit[i] = true;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        NumberOfProvince numbers = new NumberOfProvince();
        System.out.println(numbers.findCircleNum(input));
    }
}
//547. Number of Provinces / friend cycle
//        There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
//
//        A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//
//        You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//
//        Return the total number of provinces.
//
//        Example 1:
//
//        Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//        Output: 2
//        Example 2:
//
//
//        Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//        Output: 3
//
//
//        Constraints:
//
//        1 <= n <= 200
//        n == isConnected.length
//        n == isConnected[i].length
//        isConnected[i][j] is 1 or 0.
//        isConnected[i][i] == 1
//        isConnected[i][j] == isConnected[j][i]