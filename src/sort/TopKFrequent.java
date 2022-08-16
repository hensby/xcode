package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        PriorityQueue<Integer> pqueue = new PriorityQueue<>((p1, p2) -> frequentMap.get(p2) - frequentMap.get(p1));
        for (int i = 0; i < nums.length; i++) {
            frequentMap.put(nums[i], frequentMap.getOrDefault(nums[i], 0) + 1);
        }
        for (int l: frequentMap.keySet()) {
            pqueue.add(l);
        }
        int[] result = new int[k];
        for (int j = 0; j < k; j++) {
            result[j] = pqueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(topKFrequent.topKFrequent(new int[]{3,0,1,0}, 1)));
    }
}
