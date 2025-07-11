package binarySearch;

public class BinarySearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>> 1);
            int tmp = matrix[mid / n][mid % n];
            System.out.println(mid);
            if (tmp == target) return true;
            else if (tmp > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        // 二分查找
        int left = 0, right = m * n - 1;
        int pivotIdx, pivotElement;
        while (left <= right) {
            pivotIdx = (left + right) / 2;
            System.out.println(pivotIdx);
            pivotElement = matrix[pivotIdx / n][pivotIdx % n];
            if (target == pivotElement) return true;
            else {
                if (target < pivotElement) right = pivotIdx - 1;
                else left = pivotIdx + 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = col * row - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            int tmpValue = matrix[mid / col][mid % col];
            System.out.println(tmpValue + "   " + mid / row + "   " + mid % row);

            if (tmpValue == target) return true;
            else if (tmpValue > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        if (matrix != null && matrix.length > 0 && matrix[0] == null) {
            return false;
        }
        int len = matrix.length, wid = matrix[0].length;
        int left = 0, right = len * wid - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println(mid + " " + left + " " + right);
            int midValue = matrix[mid / wid][mid % wid];
            if (target == midValue) {
                return true;
            } else if (target < midValue){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchMatrix test123 = new BinarySearchMatrix();
        int[][] a = new int[][]{
                {1, 3, 5, 7},
                {10, 15, 16, 20},
                {24, 26, 31, 40}
        };
        System.out.println(test123.searchMatrix(a, 10));
        System.out.println(test123.searchMatrix1(a, 19));
        System.out.println(test123.searchMatrix2(a, 40));
        System.out.println(test123.searchMatrix3(a, 40));

    }
}
// 74. Search a 2D Matrix
//        Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than the last integer of the previous row.
//
//
//        Example 1:
//
//
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        Output: true
//        Example 2:
//
//
//        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//        Output: false
//
//
//        Constraints:
//
//        m == matrix.length
//        n == matrix[i].length
//        1 <= m, n <= 100
//        -104 <= matrix[i][j], target <= 104

