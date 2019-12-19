public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }

        if (m == 1) {
            return (int) sum;
        }

        // binary search  {7,2,5,10,8}
        long l = max;
        long r = sum;
        while (l < r) {
            long mid = l + ((r - l) >>> 1);
            if (isValid(mid, nums, m)) {
                // count <= m
                r = mid;
            } else { // count > m
                l = mid + 1;
            }
        }
        return (int) r;
    }

    // If true, count <= m
    private boolean isValid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for (int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray1(int[] nums, int m) {

        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            max = Math.max(max, nums[i]);
        }
        if (m == 1) return sum;

        int left = max, right = sum;
        while (left < right) {
            int mid = left + ((right - left) >>> 1);
            if (isValid1(mid, nums, m)){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean isValid1 (int target, int[] nums, int m){
        int count = 1;
        int total = 0;
        for (int num : nums){
            total += num;
            if (total > target) {
                total = num;
                count += 1;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int[] s = new int[]{7,2,5,10,8};
        System.out.println(splitArrayLargestSum.splitArray1(s,2));

    }
}
