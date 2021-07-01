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
        while (i < len1 && j < len2) {          // double pointer
            System.out.println(i + " " + j);
            if (slot1[i][1] < slot2[j][0]) i++;
            else if (slot2[j][0] > slot2[j][1]) j++;
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
        System.out.println(Arrays.toString(m.isAvailable1(slot1, slot2, duration)));
    }

    public int[] isAvailable1(int[][] slot1, int[][] slot2, int duration) {
        if (slot1.length == 0 || slot2.length == 0 || duration == 0) return new int[2];
        slot1 = margeSlot(slot1);
        slot2 = margeSlot(slot2);
        System.out.println(Arrays.deepToString(slot1));
        System.out.println(Arrays.deepToString(slot2));
        int index1 = 0, index2 = 0;
        while (index1 < slot1.length && index2 < slot2.length) {
            if (slot1[index1][1] <= slot2[index2][0]) index1++;
            else if (slot1[index1][0] >= slot2[index2][1]) index2++;
            else {
                int start = Math.max(slot1[index1][0], slot2[index2][0]);
                int end = Math.min(slot1[index1][1], slot2[index2][1]);
                if (end - start >= duration) {
                    return new int[] {start, start + duration};
                }
                index1++;
                index2++;
            }
        }
        return null;
    }

    public int[][] margeSlot(int[][] slot) {
        int len = slot.length;
        if (len < 2) return slot;
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(slot, (s1, s2) -> s1[0] - s2[0]);
        int index = 0;
        while (index < slot.length) {
            int start = slot[index][0], end = slot[index][1];
            while (index < len - 1 && slot[index + 1][0] <= end) {
                end = Math.max(end, slot[index + 1][1]);
                index++;
            }
            res.add(new int[]{start, end});
            index++;
        }
        return res.toArray(new int[0][2]);
    }






}

//
//   slot1{{5, 10},{15, 20}, {25, 30}}  overlap
//   slot2{{2, 19},{20, 30}}
//   duration 3
//   find earliest meeting time [5,7]
