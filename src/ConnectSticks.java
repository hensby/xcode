import java.util.PriorityQueue;

public class ConnectSticks {
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length < 2){
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : sticks){
            minHeap.add(num);
        }

        int res = 0;
        while(minHeap.size() > 1){
            int merge = minHeap.poll() + minHeap.poll();
            res += merge;
            minHeap.add(merge);
        }

        return res;
    }

    public int connectSticks1(int[] sticks) {
        if(sticks == null || sticks.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int stick : sticks){
            minHeap.add(stick);
        }
        int res = 0;
        while(minHeap.size() > 1) {
            int mergeCost = minHeap.poll() + minHeap.poll();
            res += mergeCost;
            minHeap.add(mergeCost);
        }
        return res;
    }

    public static void main(String[] args) {
        ConnectSticks connectSticks = new ConnectSticks();
        int[] sticks = new int[]{1,8,3,5};
        System.out.println(connectSticks.connectSticks(sticks));
    }

}
//        LeetCode 1167. Minimum Cost to Connect Sticks
//
//        You have some sticks with positive integer lengths.
//
//        You can connect any two sticks of lengths X and Y into one stick by paying a cost of X + Y.  You perform this action until there is one stick remaining.
//
//        Return the minimum cost of connecting all the given sticks into one stick in this way.
//
//        Example 1:
//
//        Input: sticks = [2,4,3]
//        Output: 14
//        Example 2:
//
//        Input: sticks = [1,8,3,5]
//        Output: 30
//        Constraints:
//
//        1 <= sticks.length <= 10^4
//        1 <= sticks[i] <= 10^4
