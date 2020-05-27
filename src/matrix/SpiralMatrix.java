package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, down = m - 1;
        while(left <= right && down >= top) {
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            for(int i = top + 1; i <= down; i++) res.add(matrix[i][right]);
            if(left < right && down > top) {
                for(int i = right - 1; i >= left; i--) res.add(matrix[down][i]);
                for(int i = down - 1; i > top; i--) res.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            down--;
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] matrix = new int[][] {
                {1, 2, 3, 4, 5},
//                {10, 9, 8, 7, 6}
        };
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }
}
