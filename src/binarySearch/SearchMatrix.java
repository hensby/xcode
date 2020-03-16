package binarySearch;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = n - 1;
        int top = 0, down = m - 1;
        System.out.println(colBinarySearch(matrix,4,top,down,target));
        return true;
    }

    public int colBinarySearch(int[][] matrix, int index, int top, int down, int target) {

        while(down > top) {
            int mid = top + ((down - top) >>>1);
            System.out.println(mid);
            if (matrix[index][mid] >= target) {
                down = mid - 1;
            } else top = mid + 1;
        }
        return down;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {

                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix,21));

    }
}
