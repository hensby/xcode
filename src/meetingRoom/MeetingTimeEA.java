package meetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetingTimeEA {
    public int[] isAvailable(int[][] slot1, int[][] slot2, int duration) {
        slot1 = mergeOverlap(slot1);
        slot2 = mergeOverlap(slot2);
        System.out.println(Arrays.deepToString(slot1));
        System.out.println(Arrays.deepToString(slot2));
        int len1 = slot1.length, len2 = slot2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            System.out.println(i + " " + j);
            if (slot1[i][0] < slot2[j][0] && slot1[i][1] < slot2[j][1]) i++;
            else if (slot1[i][0] > slot2[j][0] && slot1[i][1] < slot2[j][1]) j++;
            else {
                int left = Math.max(slot1[i][0], slot2[j][0]), right = Math.min(slot1[i][1], slot2[j][1]);
                if (right - left >= duration) {
                    return new int[]{left, left + duration};
                }
                i++;
                j++;
            }
        }
        return new int[2];
    }

    public int[][] mergeOverlap(int[][] slot) {
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(slot, (s1, s2) -> s1[0] - s2[0]);
        int len = slot.length;
        int i = 0;
        while (i < len) {
            int left = slot[i][0], right = slot[i][1];
            if (i < len - 1 && slot[i + 1][0] <= right) {
                right = Math.max(slot[i + 1][1], right);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][2]);
    }

    public static void main(String[] args) {
        int[][] slot1 = new int[][] {{5, 10},{9, 20}, {25, 30}};
        int[][] slot2 = new int[][] {{2, 19},{20, 30}};
        int duration = 2;
        MeetingTimeEA m = new MeetingTimeEA();
        System.out.println(Arrays.toString(m.isAvailable(slot1, slot2, duration)));
    }
}

//   [5, 20],[10, 24]
//   slot1{{5, 10},{15, 20}, {25, 30}}  overlap
//   slot2{{2, 19},{20, 30}}
//   duration 3
