package sort;

import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            size++;
            if (size > k) {
                queue.poll();
                size--;
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        KthLargestElementInArray findK = new KthLargestElementInArray();
        int[] arr1 = new int[]{3,2,3,1,2,4,5,5,6};

        System.out.println(findK.findKthLargest(arr1, 4));
        System.out.println(findK.findKthLargest1(arr1, 4));

    }
}
