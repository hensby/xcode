import java.util.PriorityQueue;
// 703
public class KthLargestElementinStream {
    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargestElementinStream(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        System.out.println(queue);
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[] { 4, 5, 8, 2 };
        KthLargestElementinStream kthLargest = new KthLargestElementinStream(k, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
