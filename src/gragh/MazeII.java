package gragh;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MazeII {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int row, col;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return 0;
        if (start[0] == destination[0] && start[1] == destination[1]) return 0;
        if (maze[destination[0]][destination[1]] == 1) return -1;
        this.row = maze.length;
        this.col = maze[0].length;
        int[][] distance = new int[row][col];
        for (int[] tmpArr: distance) {
            Arrays.fill(tmpArr, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] direction: directions) {
                int curRow = cur[0];
                int curCol = cur[1];
                int step = distance[curRow][curCol];
                while (isValid(curRow + direction[0], curCol + direction[1]) && maze[curRow + direction[0]][curCol + direction[1]] == 0) {
                    curRow += direction[0];
                    curCol += direction[1];
                    step++;
                }
                if (distance[curRow][curCol] == -1 || distance[curRow][curCol] > step) {
                    distance[curRow][curCol] = step;
                    queue.add(new int[] {curRow, curCol});
                }
            }
        }
        System.out.println(Arrays.deepToString(distance));
        return distance[destination[0]][destination[1]];
    }

    public boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col;
    }
















    public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return -1;
        }

        int m = maze.length;
        int n = maze[0].length;
        int[][] dist = new int[m][n];
        for (int[] arr : dist) {
            Arrays.fill(arr, -1);
        }

        LinkedList<int[]> que = new LinkedList<>();
        que.add(start);
        dist[start[0]][start[1]] = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] dir : dirs) {
                int x = cur[0];
                int y = cur[1];
                int step = dist[x][y];
                while (x + dir[0] >= 0 && x + dir[0] < m && y + dir[1] >= 0 && y + dir[1] < n && maze[x + dir[0]][y + dir[1]] == 0) {
                    x += dir[0];
                    y += dir[1];
                    step++;
                }

                if (dist[x][y] == -1 || dist[x][y] > step) {
                    dist[x][y] = step;
                    que.add(new int[]{x, y});
                }
            }
        }

        return dist[destination[0]][destination[1]];
    }


    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        MazeII m = new MazeII();
        System.out.println(m.shortestDistance(maze, new int[]{0, 4}, new int[]{4, 4}));
    }
}
//LeetCode 505. The Maze II
//        原题链接在这里：https://leetcode.com/problems/the-maze-ii/
//
//        题目：
//
//        There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//
//        Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
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
//        Output: 12
//
//        Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
//        The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
//
//
//        Example 2:
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
//        Input 3: destination coordinate (rowDest, colDest) = (3, 2)
//
//        Output: -1
//
//        Explanation: There is no way for the ball to stop at the destination.
//
//
//        Note:
//
//        There is only one ball and one destination in the maze.
//        Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
//        The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
//        The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
//        题解：
//
//        Use PriorityQueue to make sure smaller weight is polling out first.
//
//        Mark the current position visited when polling out the node, that means from start to this node, the shortest path has been found.
//
//        If polling out node has been marked as visited, then it means other shorter path has visited this node before.
//
//        Note: check polled out node has been visited. If not, mark it as visited.
//
//        Time Complexity: O(mn*logmn). m = maze.length. n = maze[0].length.
//
//        Space: O(mn).
//
