package gragh;

public class NumberOfProvince {
    int[][] isConnected;
    int len;
    boolean[] isVisit;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
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
        return;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        NumberOfProvince numbers = new NumberOfProvince();
        System.out.println(numbers.findCircleNum(input));
    }
}
