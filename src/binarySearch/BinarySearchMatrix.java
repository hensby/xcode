package binarySearch;

public class BinarySearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >>>1);
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



    public static void main(String[] args) {
        BinarySearchMatrix test123 = new BinarySearchMatrix();
        int[][] a = new int[][] {
                {1, 3, 5, 7},
                {10, 15, 16, 20},
                {24, 26, 31, 40}
        };
        System.out.println(test123.searchMatrix(a, 3));
    }
}



