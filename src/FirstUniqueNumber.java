import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueNumber {
    Set<Integer> all = new HashSet<>(); // 存储所有数字
    Set<Integer> unique = new LinkedHashSet<>(); // 只存储唯一数
    public FirstUniqueNumber(int[] nums) {
        for(int n : nums){ // 循环每一个数字
            if(all.contains(n)){ // 如果all中包含该数字
                // 该数字不是唯一数，将其从unique中删除
                unique.remove(n);
            }else{ // 如果all中不包含该数字
                all.add(n); // 将其添加至all
                unique.add(n); // 将其添加至unique
            }
        }
    }
    public int showFirstUnique() {
        if(unique.size()>0){ // 返回unique中首元素
            return unique.iterator().next();
        }
        return -1;
    }
    public void add(int value) {
        // 与构造函数逻辑相同
        if(all.contains(value)){
            unique.remove(value);
        }else{
            all.add(value);
            unique.add(value);
        }
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
//
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