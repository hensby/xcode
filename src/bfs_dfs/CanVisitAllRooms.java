package bfs_dfs;

import java.util.*;

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

    public boolean canVisit(List<List<Integer>> route) {
        int m = route.size();
        boolean[] visited = new boolean[m];
        visited[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            m--;

            for (int neighber : route.get(node)) {
                if (!visited[neighber]) {
                    visited[neighber] = true;
                    stack.push(neighber);
                }
            }
        }
        return m == 0;
    }

    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isVisit = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisit[0] = true;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            n--;
            for (int key: rooms.get(room)) {
                if (!isVisit[key]) {
                    isVisit[key] = true;
                    queue.add(key);
                }
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 3));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 0, 1));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(2));
        List<Integer> list4 = new ArrayList<>(Arrays.asList());
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        System.out.println(rooms);
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms));
        System.out.println(canVisitAllRooms.canVisitAllRooms1(rooms));
        System.out.println(canVisitAllRooms.canVisit(rooms));

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
        System.out.println(canVisitAllRooms.canVisit(rooms1));
        System.out.println(canVisitAllRooms.canVisitAllRooms(rooms1));
        System.out.println(canVisitAllRooms.canVisitAllRooms1(rooms1));
    }
}
/**
 * Keys and Rooms
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
