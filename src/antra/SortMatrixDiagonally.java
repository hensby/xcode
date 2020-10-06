package antra;

import java.util.Arrays;

public class SortMatrixDiagonally {
    int[][] mat;
    int m, n;
    public int[][] sortMatrix(int[][] mat) {
        if(mat == null || mat.length == 0) return mat;
        this.m = mat.length;
        this.n = mat[0].length;
        this.mat = mat;
        for(int col = 0; col < n; col++) {
            sortArray(0, col);
        }
        for(int row = 1; row < n; row++) {
            sortArray(row, 0);
        }
        return mat;
    }

    public void sortArray(int row, int col) { //
        int[] tmp = new int[Math.min(n, m)];
        int count = 0;
        while(isValid(row, col)) {
            tmp[count++] = mat[row++][col++];
        }
        int[] arr = Arrays.copyOfRange(tmp, 0, count);
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr) + " " + row + " " + col);
        for (int i = arr.length - 1; i >= 0; i--) {
            row--;
            col--;
            mat[row][col] = arr[i];
        }
    }

    public boolean isValid(int row, int col) { // in area
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {3,3,1,1},
                {2,2,1,2},
                {1,1,1,2},
        };
        SortMatrixDiagonally s = new SortMatrixDiagonally();
        System.out.println(Arrays.deepToString(s.sortMatrix(input)));
    }
}
