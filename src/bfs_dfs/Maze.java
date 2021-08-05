package bfs_dfs;

public class Maze {

    int[][] dict = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        if (m == 0 && n == 0 && maze == null) return false;
        boolean[][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;
        for (int[] tmp : dict) {
            if (dfs(maze, start, destination, tmp, visited)) return true;
        }
        return false;
    }

    public boolean dfs(int[][] maze, int[] start, int[] destination, int[] tmp, boolean[][] visited) {
        if (destination[0] == start[0] && destination[1] == start[1]) return true;
        int m = maze.length, n = maze[0].length;
        int x = start[0];
        int y = start[1];
        while (x + tmp[0] > 0 && x + tmp[0] < m && y + tmp[1] > 0 && y + tmp[1] < n && maze[x + tmp[0]][y + tmp[1]] == 0) {
            x += tmp[0];
            y += tmp[1];
        }
        if (visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        for (int[] nextDir : dict) {
            if (dfs(maze, new int[]{x, y}, destination, nextDir, visited)) {
                return true;
            }
        }
        return false;
    }

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][] maze;
    int row, col;
    int[] destination;

    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return true;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        this.maze = maze;
        this.row = maze.length;
        this.col = maze[0].length;
        this.destination = destination;
        boolean[][] isVisit = new boolean[row][col];
        isVisit[start[0]][start[1]] = true;
        for (int[] direction : directions) {
            if (dfs1(start[0], start[1], direction, isVisit)) return true;
        }
        return false;
    }

    public boolean dfs1(int r, int c, int[] direction, boolean[][] isVisit) {
        if (destination[0] == r && destination[1] == c) return true;
        System.out.println("before" + r + " " + c);
        while (isValid(r + direction[0], c + direction[1]) && maze[r + direction[0]][c + direction[1]] == 0) {
            r += direction[0];
            c += direction[1];
        }
        System.out.println("after" + r + " " + c);

        if (isVisit[r][c]) {
            return false;
        }
        isVisit[r][c] = true;
        for (int[] dict : directions) {
            if (dfs1(r, c, dict, isVisit)) return true;
        }
        return false;
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        Maze m = new Maze();
        System.out.println(m.hasPath1(maze, new int[]{0, 4}, new int[]{4, 4}));
    }
}
//   LeetCode 490. The Maze
//   https://www.cnblogs.com/Dylan-Java-NYC/p/11926514.html
//        There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//        Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
//
//        The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
//
//        Example 1:
//
//        Input 1: a maze represented by a 2D array
//
//        0 0 1 0 0
//        0 0 0 0 0
//        0 0 0 1 0
//        1 1 0 1 1
//        0 0 0 0 0
//
//        Input 2: start coordinate (rowStart, colStart) = (0, 4)
//        Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//
//        Output: true
//
//        Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.