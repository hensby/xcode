package gragh;

public class Maze {
    int [][] dirs = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){
            return false;
        }

        int m = maze.length;
        int n = maze[0].length;
        boolean [][] visited = new boolean[m][n];
        visited[start[0]][start[1]] = true;

        for(int [] dir : dirs){
            if(dfs(maze, start, destination, dir, visited)){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] maze, int[] start, int[] dest, int [] dir, boolean [][] visited){
        int m = maze.length;
        int n = maze[0].length;

        int r = start[0];
        int c = start[1];

        if(r == dest[0] && c ==dest[1]){
            return true;
        }

        while(r+dir[0]>=0 && r+dir[0]<m && c+dir[1]>=0 && c+dir[1]<n && maze[r+dir[0]][c+dir[1]]==0){
            r += dir[0];
            c += dir[1];
        }

        if(visited[r][c]){
            return false;
        }

        visited[r][c] = true;
        for(int [] nextDir : dirs){
            if(dfs(maze, new int[]{r,c}, dest, nextDir, visited)){
                return true;
            }
        }

        return false;
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
        System.out.println(m.hasPath(maze, new int[]{0, 4},new int[]{4, 4}));
    }
}
//LeetCode 490. The Maze
//  https://www.cnblogs.com/Dylan-Java-NYC/p/11926514.html
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