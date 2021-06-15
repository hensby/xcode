package Amazon_oa;

import java.util.*;

public class ItemsInContainers {

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        if (startIndices == null || endIndices == null || endIndices.size() != startIndices.size()) return null;
        char[] sCharArray = s.toCharArray();
        int[] starCountArray = new int[s.length()];
        int count = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (sCharArray[i] == '|') {
                starCountArray[i] = count;
            } else {
                count++;
            }
        }
        System.out.println(Arrays.toString(starCountArray));
        for (int i = 0; i < startIndices.size(); i++) {
            int start = startIndices.get(i) - 1;
            int end = endIndices.get(i) - 1;
            while (start < end && sCharArray[start] != '|') {
                start++;
            }
            while (start < end && sCharArray[end] != '|') {
                end--;
            }
            res.add(starCountArray[end] - starCountArray[start]);
        }
        return res;
    }


    public static List<Integer> numberOfItems1(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cumSum = 0;
        boolean started = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                if (started) {
                    cumSum += sum;
                    map.put(i, cumSum);
                } else
                    map.put(i, 0);
                started = true;
                sum = 0;
            } else {
                sum++;
            }
        }
        int right = -1;
        int[] rightBoundary = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                right = i;
            }
            rightBoundary[i] = right;
        }
        int left = -1;
        int[] leftBoundary = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                left = i;
            }
            leftBoundary[i] = left;
        }
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < startIndices.size(); i++) {
            int start = rightBoundary[startIndices.get(i) - 1];
            int end = leftBoundary[endIndices.get(i) - 1];
            if (start != -1 && right != -1 && start < end) {
                res.add(map.get(end) - map.get(start));
            } else
                res.add(0);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<Integer>() {{
            add(1);
            add(1);
        }};
        List<Integer> endIndices = new ArrayList<Integer>() {{
            add(5);
            add(6);
        }};
        System.out.println(numberOfItems1(s, startIndices, endIndices));
    }
}

//          Example:
//        s = '|**|*|*'
//        startIndices = [1,1]
//        endIndices = [5,6]
//
//        The String has a total 2 closed compartments, one with 2 items and one with 1 item. For the first par of indices, (1,5), the substring is '|**|*'. There are 2 items in a compartment.
//        For the second pair of indices, (1,6), the substring is '|**|*|' and there 2+1=3 items in compartments.
//        Both of the answers are returned in an array. [2,3].


