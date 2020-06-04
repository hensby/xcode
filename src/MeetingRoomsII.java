import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

//    Definition for an interval.
    public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, (l1, l2)-> l1.start - l2.start);
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        int rooms = 0;
        for(int i = 0; i < intervals.length; i++) {
            endQueue.offer(intervals[i].end);
            System.out.println(intervals[i].start);
            if(intervals[i].start < endQueue.peek()) {

                rooms ++;
            } else {
                endQueue.poll();
            }
            System.out.println(endQueue);
        }
        System.out.println(endQueue.size());
        return rooms;
    }

    public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
//        Interval[] intervals = {new Interval(1,10),new Interval(11, 20), new Interval(15, 30)};
        Interval[] intervals = {new Interval(0,30),new Interval(5, 10), new Interval(15, 20)};
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
    }
}
// [LeetCode] 253. Meeting Rooms II 会议室之二
//
//
//        Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//        Example 1:
//
//        Input: [[0, 30],[5, 10],[15, 20]]
//        Output: 2
//        Example 2:
//
//        Input: [[7,10],[2,4]]
//        Output: 1
