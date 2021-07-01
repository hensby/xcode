package meetingRoom;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {

//    Definition for an interval.
    public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    public int minMeetingRooms1(Interval[] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (i1, i2)-> i1.start - i2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((i1, i2) -> i1.end - i2.end);
        pq.add(intervals[0]);
        for(int i = 1; i < len; i++) {
            System.out.println(pq);
            Interval tmp = pq.peek();
            if(intervals[i].start > tmp.end) {
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }

    public int minMeetingRooms(Interval[] intervals) {
        int len = intervals.length;
        Arrays.sort(intervals, (i1, i2)-> i1.start - i2.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0].end);
        for(int i = 1; i < len; i++) {
            System.out.println(pq);
            if(intervals[i].start > pq.peek()) pq.poll();
            pq.add(intervals[i].end);
        }
        return pq.size();
    }

    public int minMeetingRooms2(Interval[] intervals) {

        Arrays.sort(intervals, (i1, i2) -> i1.start - i2.start);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((i1, i2) -> i1.end - i2.end);
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval endInterval = pq.peek();
            if (intervals[i].start >= endInterval.end) {
                pq.poll();
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }

        public static void main(String[] args) {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        Interval[] intervals = {new Interval(1,10),new Interval(11, 20), new Interval(15, 30), new Interval(25, 40)};
        Interval[] intervals1 = {new Interval(0,30),new Interval(5, 10), new Interval(15, 20)};
        System.out.println(meetingRoomsII.minMeetingRooms(intervals));
        System.out.println(meetingRoomsII.minMeetingRooms(intervals1));

        Interval[] intervals2 = {new Interval(0,3),new Interval(5, 10), new Interval(15, 20)};
        System.out.println(meetingRoomsII.minMeetingRooms1(intervals2));


    }
}
//        [LeetCode] 253. Meeting Rooms II 会议室之二
//
//
//        Given an array of meeting time intervals consisting of start and end times
//        [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//        Example 1:
//
//        Input: [[0, 30],[5, 10],[15, 20]]
//        Output: 2
//        Example 2:
//
//        Input: [[7,10],[2,4]]
//        Output: 1
