package meetingRoom;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for(int i = 1; i < intervals.length; ++i) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRoom meeting = new MeetingRoom();
        int[][] input = new int[][] {{0, 30},{5, 10},{15, 20}};
        System.out.println(meeting.canAttendMeetings(input));
    }
}
//    leetcode 252
//    Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
//
//        For example,
//        Given [[0, 30],[5, 10],[15, 20]],
//        return false.
