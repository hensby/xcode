package gragh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumbersOfDistinctIsland {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, visited, i, j, sb);
                if(sb.length() > 0) {
                    set.add(sb.toString());
                }
            }
        }
        System.out.println(set);
        return set.size();
    }

    void dfs(int[][] grid, int x, int y, boolean[][] visited, int ox, int oy, StringBuilder sb) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return;
        if(visited[x][y] || grid[x][y] != 1) return;
        visited[x][y] = true;
        System.out.println("ox "+ ox + " oy " + oy + " x " + x + " y " + y);
        sb.append(x - ox).append(".").append(y-oy).append(".");

        int[][] dirs = {{-1,0}, {1,0}, {0,1}, {0, -1}};
        for(int i = 0; i < dirs.length; ++i) {
            int nextx = x + dirs[i][0];
            int nexty = y + dirs[i][1];
            dfs(grid, nextx, nexty, visited, ox, oy, sb);
        }
    }

    public int numDistinctIslands1(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        HashSet<List<Integer>> shapes = new HashSet<List<Integer>>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<Integer> shape = new ArrayList<Integer>();
                    dfs(grid, i, j, shape, 0);
                    System.out.println(shapes);
                    shapes.add(shape);
                }
            }
        }

        return shapes.size();
    }

    private void dfs(int[][] grid, int i, int j, List<Integer> shape, int direction){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1){
            return;
        }

        grid[i][j] = 0;
        shape.add(direction);
        dfs(grid, i-1, j, shape, 1);
        dfs(grid, i+1, j, shape, 2);
        dfs(grid, i, j-1, shape, 3);
        dfs(grid, i, j+1, shape, 4);

        shape.add(0);
    }

    public static void main(String[] args) {
        NumbersOfDistinctIsland numbersOfDistinctIsland = new NumbersOfDistinctIsland();
        int[][] grid = new int[][] {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        };
        System.out.println(numbersOfDistinctIsland.numDistinctIslands1(grid));
    }
}
//        [LeetCode] 694. Number of Distinct Islands 不同岛屿的个数
//
//
//        Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//        Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
//
//        Example 1:
//
//        11000
//        11000
//        00011
//        00011
//        Given the above grid map, return 1.
//
//
//
//        Example 2:
//
//        11011
//        10000
//        00001
//        11011
//        Given the above grid map, return 3.
//
//        Notice that:
//
//        11
//        1
//        and
//
//        1
//        11
//        are considered different island shapes, because we do not consider reflection / rotation.
//
//
//
//        Note: The length of each dimension in the given grid does not exceed 50.