package SlidingWindow;

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            System.out.println(c);
            if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
//                System.out.println(c * Integer.compare(A[i], A[i+1]));
                if (c != 0) ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }

    public int maxTurbulenceSize1(int[] arr) {
        int len = arr.length;
        if (len < 2) {
            return len;
        }

        int left = 0;
        int right = 1;
        // 为 true 表示 arr[i - 1] < arr[i]
        boolean pre = false;
        int res = 1;
        while (right < len) {
            boolean current = arr[right - 1] < arr[right];
            if (current == pre) {
                left = right - 1;
            }
            if (arr[right - 1] == arr[right]) {
                left = right;
            }
            right++;
            res = Math.max(res, right - left);
            pre = current;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[] {9,4,2,10,7,8,8,1,9};
        LongestTurbulentSubarray longest = new LongestTurbulentSubarray();
        System.out.println(longest.maxTurbulenceSize(input));
//        System.out.println(Integer.compare(5, 3));
    }
}
// 978
