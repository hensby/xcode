package binarySearch;

public class FirstBadVersion {

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return isBadVersion(left)? left: -1;
    }

    static int bar;
    public static boolean isBadVersion(int index) {
        return index >= bar;
    }

    public static void main(String[] args) {
        bar = 4;
        System.out.println(firstBadVersion(5));
    }
}
