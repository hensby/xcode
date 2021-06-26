package binarySearch;

public class SearchMatrix {
    // 1
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = n - 1;
        int top = 0, down = m - 1;
        System.out.println(colBinarySearch(matrix, 4, top, down, target));
        return true;
    }

    //2
    public int colBinarySearch(int[][] matrix, int index, int top, int down, int target) {

        while (down > top) {
            int mid = top + ((down - top) >>> 1);
            System.out.println(mid);
            if (matrix[index][mid] >= target) {
                down = mid - 1;
            } else top = mid + 1;
        }
        return down;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row >= 0 && row < m && col >= 0 && col < n) {
            System.out.println(row + "  " + col + " " + matrix[row][col]);
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row++;
            else col--;
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][]{

                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 21));
        System.out.println(searchMatrix.searchMatrix1(matrix, 21));
        System.out.println(searchMatrix.searchMatrix2(matrix, 21));

    }

    // 3
    private int[][] matrix;
    private int target;

    private boolean searchRec1(int left, int up, int right, int down) {
        // this submatrix has no height or no width.
        if (left > right || up > down) {
            return false;
            // `target` is already larger than the largest element or smaller
            // than the smallest element in this submatrix.
        } else if (target < matrix[up][left] || target > matrix[down][right]) {
            return false;
        }
        int mid = left + (right - left) / 2;
        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
        int row = up;
        while (row <= down && matrix[row][mid] <= target) {
            if (matrix[row][mid] == target) {
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid - 1, down) || searchRec(mid + 1, up, right, row - 1);
    }

    public boolean searchMatrix2(int[][] mat, int targ) {
        // cache input values in object to avoid passing them unnecessarily
        // to `searchRec`
        matrix = mat;
        target = targ;

        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        return searchRec(0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private boolean searchRec(int left, int up, int right, int down) {
        if (left > right || up > down) {
            return false;
        } else if (matrix[up][left] > target || matrix[down][right] < target){
            return false;
        }
        int midCol = left + (right - left) / 2;

        while (up <= down) {
            int midRow = up + ((down - up) >>>1);
            if (matrix[midRow][midCol] == target) return true;
            else if (matrix[midRow][midCol] > target) down = midRow - 1;
            else up = midRow + 1;
        }
        return searchRec(left, up, midCol - 1, down) || searchRec(midCol + 1, up, right, up - 1);
    }


}
// 240. Search a 2D Matrix II