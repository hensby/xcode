package sort;

public class QuickSort {
    private static void sort(int[] arr, int l, int r) {
        int i = l;
        int j = r;
        if (l < r) {
            while (l < r) {
                while (l < r && arr[r] >= arr[l]) {
                    r--;
                }
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;

                while (l < r && arr[l] <= arr[r]) {
                    l++;
                }
                tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;

            }
            sort(arr, i, l - 1);//递归左边，此时l=5
            sort(arr, l + 1, j);//递归右边，此时l=5
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,2,1,8,9,3,7,0,4,6};
        sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
