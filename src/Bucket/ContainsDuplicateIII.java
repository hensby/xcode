package Bucket;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        // use k-size slide window
        Map<Long, Long> map = new HashMap<>();
        // key is bucket, value is the actual remapped number
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket) // bucket have two nums, to close to previous bucket/ ext bucket.
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) {
                return true;
            }
            if (map.size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE)
                        / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        // use k-size slide window
        Map<Long, Integer> map = new HashMap<>();
        // key is bucket, value is the actual number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            long bucket = getBucket(num, t); // use long to prevent overflow
            if (map.containsKey(bucket)
                    || isBucketAlmostDuplicate(map, bucket - 1, num, t)
                    || isBucketAlmostDuplicate(map, bucket + 1, num, t)) {
                return true;
            }
            if (map.size() >= k) {
                long lastBucket = getBucket(nums[i - k], t);
                map.remove(lastBucket);
            }
            map.put(bucket, num);
        }
        return false;
    }

    private boolean isBucketAlmostDuplicate(
            Map<Long, Integer> map, long bucket, int num, int t) {
        Integer n = map.get(bucket);
        if (n == null) {
            return false;
        }

        return Math.abs((long) n - num) <= t;
    }

    private long getBucket(int num, int t) {
        long bucket = num / ((long) t + 1);
        // shift bucket one left if negative
        return num < 0 ? bucket - 1 : bucket;
    }


    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsDuplicateIII.containsNearbyAlmostDuplicate(nums, 3, 0));

    }
}
