import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueNumber {
    Set<Integer> all = new LinkedHashSet<Integer>();
    Set<Integer> unique = new LinkedHashSet<Integer>();
    public FirstUniqueNumber(int[] nums) {
        for(int num: nums) {
            if(!all.contains(num)) {
                all.add(num);
                unique.add(num);
            } else unique.remove(num);
        }
    }
    public int showFirstUnique() {
        if(!unique.isEmpty()) return unique.iterator().next();
        return -1;
    }
    public void add(int value) {
        if(!all.contains(value)) {
            all.add(value);
            unique.add(value);
        } else unique.remove(value);
    }

    public static void main(String[] args) {
        FirstUniqueNumber firstUnique = new FirstUniqueNumber(new int[] {7,7,7,7,7,7});
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }

}
//        LEETCODE 1429. First Unique Number
//
//        You have a queue of integers, you need to retrieve the first unique integer in the queue.
//
//        Implement the firstUnique class:
//
//        firstUnique(int[] nums) Initializes the object with the numbers in the queue.
//        int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
//        void add(int value) insert value to the queue.
//        Example 1:
//        Input:
//        ["firstUnique","showFirstUnique","add","showFirstUnique","add","showFirstUnique","add","showFirstUnique"]
//        [[[2,3,5]],[],[5],[],[2],[],[3],[]]
//        Output: [null,2,null,2,null,3,null,-1]
//        Explanation:
//        firstUnique firstUnique = new firstUnique([2,3,5]);
//        firstUnique.showFirstUnique(); // return 2
//        firstUnique.add(5); // the queue is now [2,3,5,5]
//        firstUnique.showFirstUnique(); // return 2
//        firstUnique.add(2);            // the queue is now [2,3,5,5,2]
//        firstUnique.showFirstUnique(); // return 3
//        firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
//        firstUnique.showFirstUnique(); // return -1
//        Example 2:
//
//        Input:
//        ["firstUnique","showFirstUnique","add","add","add","add","add","showFirstUnique"]
//        [[[7,7,7,7,7,7]],[],[7],[3],[3],[7],[17],[]]
//        Output:
//        [null,-1,null,null,null,null,null,17]
//        Explanation:
//        firstUnique firstUnique = new firstUnique([7,7,7,7,7,7]);
//        firstUnique.showFirstUnique(); // return -1
//        firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
//        firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
//        firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
//        firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
//        firstUnique.showFirstUnique(); // return 17
//        Example 3:
//
//        Input:
//        ["firstUnique","showFirstUnique","add","showFirstUnique"]
//        [[[809]],[],[809],[]]
//        Output:
//        [null,809,null,-1]
//        Explanation:
//        firstUnique firstUnique = new firstUnique([809]);
//        firstUnique.showFirstUnique(); // return 809
//        firstUnique.add(809); // the queue is now [809,809]
//        firstUnique.showFirstUnique(); // return -1
//        Constraints:
//
//        1 <= nums.length <= 10^5
//        1 <= nums[i] <= 10^8
//        1 <= value <= 10^8
//        At most 50000 calls will be made to showFirstUnique and add.