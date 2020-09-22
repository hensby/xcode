package meetingRoom;

import java.util.*;

public class UniversityCareerFair {
    public static int maxEvents(List<Integer> arrivals, List<Integer> departures) {
        int[][] events = new int[arrivals.size()][2];
        for(int i = 0; i < arrivals.size(); i++) {
            events[i][0] = arrivals.get(i);
            events[i][1] = arrivals.get(i) + departures.get(i);
        }
        Arrays.sort(events, (a, b)->(a[1] - b[1]));
        int end = events[0][1];
        Queue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        queue.add(events[0]);
        for(int i = 1; i < events.length; i++) {
            if(events[i][0] < end) {
                queue.add(events[i]);
            } else {
                end = events[i][1];
            }
        }
        return arrivals.size() - queue.size() + 1;
    }

    public static void main(String[] args) {
        List<Integer> arrival = new ArrayList<>(Arrays.asList(1,3,3,5,7,6,9));
        List<Integer> duration = new ArrayList<>(Arrays.asList(2,2,1,2,1,10,2));
        System.out.println(maxEvents(arrival, duration));
    }
}
// roblox
// start time + duration time
