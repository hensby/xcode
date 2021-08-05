package bfs_dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        int[] a = decodeFromVariableBase(--k, n - 1);
        List<Character> l = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            l.add((char) (i + 48));
        }
        // O(n^2)
        for (int i = 0; i < a.length; i++) {
            int index = a[i];
            result[i] = l.remove(index);
        }

        result[n - 1] = l.remove(0);
        return new String(result);
    }

    // Encoding:
    // weight(i) = (i+1)!
    // As an example, take our {1, 1, 1, 0}, with the rightmost element
    // stripped off as mentioned before:
    // {1, 1, 1}. Our sum is 1 * 3! + 1 * 2! + 1 * 1! = 9.
    private int[] decodeFromVariableBase(int n, int len) {
        int[] result = new int[len];
        int base = 2;
        for (int i = len - 1; i >= 0; i--) {
            result[i] = n % base;
            n /= base;
            base++; // b[k+1] = b[k] + 1
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        GetPermutation getPermutation = new GetPermutation();
        System.out.println(getPermutation.getPermutation(3,3));
    }
}
