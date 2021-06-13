package Amazon_oa;

import java.io.*;

public class NumberOfSwapsToSort {
    // Java program to count number of
// swaps required to sort an array
// when only swapping of adjacent
// elements is allowed.


    // This function merges two sorted
// arrays and returns inversion
// count in the arrays.
    static int merge(int arr[], int temp[],
                     int left, int mid, int right) {
        int inv_count = 0;

        /* i is index for left subarray*/
        int i = left;

        /* i is index for right subarray*/
        int j = mid;

        /* i is index for resultant merged subarray*/
        int k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];

			/* this is tricky -- see above /
			explanation diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

	/* Copy the remaining elements of left
	subarray (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

	/* Copy the remaining elements of right
	subarray (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

	/*Copy back the merged elements
	to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }

    // An auxiliary recursive function that
// sorts the input array and returns
// the number of inversions in the array.
    static int _mergeSort(int arr[], int temp[],
                          int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            // Divide the array into two parts and
            // call _mergeSortAndCountInv() for
            // each of the parts
            mid = (right + left) / 2;

		/* Inversion count will be sum of
		inversions in left-part, right-part
		and number of inversions in merging */
            inv_count = _mergeSort(arr, temp,
                    left, mid);

            inv_count += _mergeSort(arr, temp,
                    mid + 1, right);

            /*Merge the two parts*/
            inv_count += merge(arr, temp,
                    left, mid + 1, right);
        }

        return inv_count;
    }

    // This function sorts the input
// array and returns the number
// of inversions in the array
    static int countSwaps(int arr[], int n) {
        int temp[] = new int[n];
        return _mergeSort(arr, temp, 0, n - 1);
    }

    // Driver Code
    public static void main(String[] args) {

        int arr[] = {1, 20, 6, 4, 5};
        int n = arr.length;
        System.out.println("Number of swaps is "
                + countSwaps(arr, n));
    }
}
