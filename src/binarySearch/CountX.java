package binarySearch;

/**
 * sorted array [1, 2, 2, 2, 4, 5, 9],
 * x = 2 return 3
 * x = 9 return 1
 * x = 10 return 0
 */
public class CountX {

    public static int countX(int[] arr, int x) {
        int n = arr.length;
        int left = findFirst(arr, 0, n - 1, x);
        if (left == -1) {
            return 0;
        }

        int right = findLast(arr, left, n - 1, x);
        return right - left + 1;
    }

    private static int findFirst(int[] nums, int start, int end, int target) {
        // find first occurrence of target in range [left, right], return index
        int result = -1;
        while (start <= end && nums[start] <= target && target <= nums[end]) {
            if (nums[start] == target) {
                return start;
            }
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                end = mid - 1;
                result = mid;
            } else if (nums[mid] > target)
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int findLast(int[] nums, int start, int end, int target) {
        // find last occurrence of target in range [left, right], return index
        int result = -1;
        while (start <= end && nums[start] <= target && target <= nums[end]) {
            if (nums[end] == target) {
                return end;
            }
            int mid = start + ((end - start) >>> 1);
            if (nums[mid] == target) {
                start = mid + 1;
                result = mid;
            } else if (nums[mid] > target)
                end = mid - 1;
            else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static int countX1(int[] arr, int x) {
        if (arr == null || arr.length == 0) return 0;
        int left = findFirst1(arr, x);
        int right = findLast1(arr, x);
        System.out.println(left + "   " + right);
        return right - left + 1;
    }

    private static int findFirst1(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (arr[mid] >= x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int findLast1(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (arr[mid] <= x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


        public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 4, 5, 9};
        System.out.println(countX1(arr, 2));
        System.out.println(countX1(arr, 9));
        System.out.println(countX1(arr, 10));
    }
}
