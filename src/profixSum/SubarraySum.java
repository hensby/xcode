package profixSum;

import java.util.HashMap;
// 560
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        System.out.println(mp);
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                3,4,7,2,-3,7,4,2};
        SubarraySum s = new SubarraySum();
        System.out.println(s.subarraySum(input, 7));
    }
}
