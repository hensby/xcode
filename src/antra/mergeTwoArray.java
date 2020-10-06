package antra;

import java.util.Arrays;

public class mergeTwoArray { // merge two array of int
    public static int[] mergeArray(int[] a, int[] b) {
        if(a.length == 0 && b.length == 0) return new int[0];
        if(a.length == 0) return b;
        if(b.length == 0) return a;
        int[] c = new int[a.length + b.length];
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
            count++;
        }
        for (int j = 0; j < b.length; j++) {
            c[count++] = b[j];
        }
        return c;
    }

    public static void main(String[] args) {
        int[]a = {1,2,3,4};
//        int[] a = {};
        int[]b = {4,16,1,2,3,22};
        System.out.println(Arrays.toString(mergeArray(a, b)));
    }
}
