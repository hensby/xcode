package Amazon_onsite;

public class FloodFill {

    int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int currentColor, newColor;
    int[][] image;
    int row;
    int col;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image == null || image.length == 0) return image;
        this.currentColor = image[sr][sc];
        this.newColor = newColor;
        if (currentColor == newColor) return image;
        this.image = image;
        this.row = image.length;
        this.col = image[0].length;

        dfs(sr, sc);
        return image;
    }

    public void dfs(int r, int c) {
        if(isVaild(r, c) ) {
            if (image[r][c] != currentColor) return;
            image[r][c] = newColor;
            for(int[] direction: directions) {
                dfs(r + direction[0], c + direction[1]);
            }
        }
        return;
    }

    public boolean isVaild(int r, int c) {

        return r >= 0 && r < row && c >= 0 && c < col;
    }

    public static void main(String[] args) {

    }

}
//时间复杂度：O(n\times m)O(n×m)，其中 nn 和 mm 分别是二维数组的行数和列数。最坏情况下需要遍历所有的方格一次。
//空间复杂度：O(n\times m)O(n×m)，其中 nn 和 mm 分别是二维数组的行数和列数。主要为栈空间的开销。
//733. Flood Fill
//        An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//        You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//        To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
//
//        Return the modified image after performing the flood fill.
//
//
//
//        Example 1:
//
//
//        Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
//        Output: [[2,2,2],[2,2,0],[2,0,1]]
//        Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
//        Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
//        Example 2:
//
//        Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
//        Output: [[2,2,2],[2,2,2]]