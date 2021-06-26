package binarySearch;

public class BinarySearch {
    public int binarySearch(int[] a, int fromIndex, int toIndes, int key) {
        int low = fromIndex, high = toIndes - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch.binarySearch(nums, 0, 9, 2));
        System.out.println(binarySearch.binarySearch(nums, 0, 9, 99));
    }
}
