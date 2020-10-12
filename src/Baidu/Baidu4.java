package Baidu;
import java.util.Arrays;
import java.util.Scanner;

public class Baidu4 {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int length = s.nextInt();
        int time = s.nextInt();

        int[][] matrix = new int[length][length];
        for(int i = 0; i < time; i++) {
            int left = s.nextInt();
            int right = s.nextInt();
            matrix[left - 1][right - 1] = 1;
        }
        System.out.println(Arrays.deepToString(matrix));
        int[] res = compareWeight(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.toString(res));
    }

    public static int[] compareWeight(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[2];
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(i == j) continue;
                if(i > 0 && j > 0 && matrix[i][j] == 1) {
                    for(int k = 0; k < col; k++) {
                        if(matrix[j][k] == 1) {
                            matrix[i][k] = 1;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < row; i++) {
            boolean flag = true;
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == 1) flag = false;
            }
            if(flag) {
                if(res[1]== 0) res[1] = i + 1;
                else res[1] = -1;
            }
            flag = false;
        }
        for(int i = 0; i < col; i++) {
            boolean flag = true;
            for(int j = 0; j < row; j++) {
                if(matrix[j][i] == 1) flag = false;
            }
            if(flag) {
                if(res[0]== 0) res[0] = i + 1;
                else res[0] = -1;
            }
            flag = false;
        }
        return res;
    }
}
