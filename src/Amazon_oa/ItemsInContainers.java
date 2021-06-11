package Amazon_oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        public static void main(String[] args) {
        String s = "|**|*|*";
        List<Integer> startIndices = new ArrayList<Integer>(){{add(1);add(1);}};
        List<Integer> endIndices =  new ArrayList<Integer>(){{add(5);add(6);}};
        System.out.println(numberOfItems(s, startIndices, endIndices));
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


