package gragh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] seen = new boolean[n];  //visited
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        // At the beginning, we have a to do list "stack" of keys to use.
        // 'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            System.out.println(stack);
            int node = stack.pop(); // Get the next key 'node'

            n--;
            for (int neighbor : rooms.get(node)) // For every key in room # 'node'
                if (!seen[neighbor]) { // ...that hasn't been used yet
                    seen[neighbor] = true; // mark that we've entered the room
                    stack.push(neighbor); // add the key to the to do list
                }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list4 = new ArrayList<>(Arrays.asList());
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        List<List<Integer>> rooms1 = new ArrayList<>();
        List<Integer> list11 = new ArrayList<>(Arrays.asList(1));
        List<Integer> list12 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list13 = new ArrayList<>(Arrays.asList(3));
        List<Integer> list14 = new ArrayList<>(Arrays.asList());
        rooms1.add(list11);
        rooms1.add(list12);
        rooms1.add(list13);
        rooms1.add(list14);
        System.out.println(rooms1);
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms1));

    }
}
/**
 * Keys and Rooms
 There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

 Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

 Initially, all the rooms start locked (except for room 0).

 You can walk back and forth between rooms freely.

 Return true if and only if you can enter every room.

 Example 1:

 Input: [[1],[2],[3],[]]
 Output: true
 Explanation:
 We start in room 0, and pick up key 1.
 We then go to room 1, and pick up key 2.
 We then go to room 2, and pick up key 3.
 We then go to room 3.  Since we were able to go to every room, we return true.
 Example 2:

 Input: [[1,3],[3,0,1],[2],[0]]
 Output: false
 Explanation: We can't enter the room with number 2.
 Note:

 1 <= rooms.length <= 1000
 0 <= rooms[i].length <= 1000
 The number of keys in all rooms combined is at most 3000.
 */