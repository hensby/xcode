import java.util.PriorityQueue;

public class ZhuanZhuan {

    public int get2GreatNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        int res = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((l1, l2) -> l2 - l1);
        for (int i = 0; i < numbers.length; i++) {
            queue.add(numbers[i]);
        }
        for (int i = 0; i < 2; i++) {
            res = queue.poll();
        }
        return res;
    }
}
//    O(n) times
//    一位数组 第二大
