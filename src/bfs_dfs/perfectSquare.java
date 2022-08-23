package bfs_dfs;

import java.util.*;

public class perfectSquare {
    public static int numSquares(int n) {
        if (n <= 1) return n;
        List<Integer> squareList = generateSquare(n);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();
        queue.add(0);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                for (int suqare: squareList) {
                    int nextSum = current + suqare;
                    if (nextSum == n) return level;
                    if (nextSum > n) break;
                    if (nextSum < n && !visitedSet.contains(nextSum)) {
                        visitedSet.add(nextSum);
                        queue.add(nextSum);
                    }
                }
            }
        }
        return -1;
    }

    public static List<Integer> generateSquare(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (i * i > n) break;
            result.add(i * i);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
